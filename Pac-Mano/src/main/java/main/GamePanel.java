package main;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import entity.Ghost;
import entity.GhostGroup;
import entity.Player;
import events.Eventchecker;
import gamestates.MenuState;
import gamestates.Pauser;
import items.PelletGroup;
import position.Node;
import position.NodeGroup;
import texts.Life;
import texts.TextGroup;
import tile.MenuTile;
import tile.TileManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class GamePanel extends DefaultTerminalFactory implements Runnable {
    public Screen screen;
    Thread gameThread;
    TextGraphics graphics;
    Terminal terminal;
    public KeyCentral keyCentral;
    KeyStroke key;
    public Sound sound ;
    TileManager tileManager;
    public Player player;
    NodeGroup nodeGroup;

    public PelletGroup pelletGroup;

    Eventchecker eventchecker;

    public Pauser pauser;

    public GhostGroup ghostGroup;

    public TextGroup textgroup;

    MenuTile menutile;

    public Life life;

    //Settings
    public final int tileSize = 16 ;// 16*16
    final int scale = 1;
    public final int maxScreenCol = 19;
    public final int maxScreenRow = 25;

    final int screenWidth = maxScreenCol*tileSize;
    final int screenHeight = maxScreenRow*tileSize;

    public MenuState gs = MenuState.MENU;

    //FPS
    int FPS = 30;

    GamePanel() throws IOException, FontFormatException, URISyntaxException {
        //Font
        URL resource = getClass().getClassLoader().getResource("Square_3.ttf");
        assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);
        Font loadedFont = font.deriveFont(Font.PLAIN, scale);
        //Graphics Environment
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        //AWT Terminal
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        //Game panel Config
        this.setTerminalEmulatorFontConfiguration(fontConfig);
        this.setForceAWTOverSwing(true);
        this.setTerminalEmulatorTitle("PAC-MANO");
        this.setInitialTerminalSize(new TerminalSize(screenWidth,screenHeight));
        //Screen Creation
        terminal = this.createTerminal()    ;
        screen = new TerminalScreen(terminal);
        graphics = screen.newTextGraphics();
        //Screen Config
        screen.startScreen();
        screen.setCursorPosition(null);
        screen.doResizeIfNecessary();
        //playMusic(0);
        //Start Game
        this.menutile = new MenuTile(this,gs);
        startGame();
        //TextGroup
        this.textgroup = new TextGroup(this);
    }

    public void startGameThread() {
        gameThread=new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1_000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawcount = 0;

        while (gameThread!=null) {
            currentTime = System.nanoTime();

            delta += (currentTime-lastTime)/drawInterval;
            timer += currentTime-lastTime;
            lastTime = currentTime;
            if (delta > 1){
                //Process key
                try {
                    key = screen.pollInput();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (key!=null){
                    keyCentral.process(key,gs);
                }
                //1-Update info
                try {
                    update();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                keyCentral.reset();
                //2-Draw
                try {
                    draw();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                delta--;
                drawcount++;
            }
            if (timer >= 1_000_000_000){
                System.out.println("FPS:" + drawcount);
                drawcount = 0;
                timer = 0;
            }
        }
    }

    public void update() throws IOException {
        if (!pauser.paused){
            player.update();
            Eventchecker.checkEvents();
            ghostGroup.update();
        }
        checkEvents();
        pauser.update();
}

    public void draw() throws IOException {
        if(gs == MenuState.GAME){

            //screen.clear();
            graphics.setBackgroundColor(TextColor.Factory.fromString("#130E1D"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(screenWidth, screenHeight), ' ');
            tileManager.draw(graphics);
            //nodeGroup.draw(graphics);
            pelletGroup.draw(graphics);
            player.draw(graphics);
            ghostGroup.draw(graphics);
            textgroup.draw(graphics);
            life.draw(graphics);
            screen.refresh();
        }
        else if(gs == MenuState.MENU){
            menutile.draw(graphics);
            screen.refresh();
            if (keyCentral.pp0pressed) {
                gs=MenuState.GAME;
            }
            if (keyCentral.pp1pressed) { //Exits game
                System.exit(0);
            }
        }
    }

    public void playMusic(int i){
        sound.play(i);
        sound.loop(i);
    }

    public void stopMusic(int i){
        sound.stop(i);
    }
    public void playSE(int i){
        sound.play(i);
    }

    public boolean isThreadAlive(){
        return gameThread.isAlive();
    }

    void checkEvents() throws IOException {
        if (keyCentral.q2pressed){
                screen.close();
             gameThread.stop();
        } else if (keyCentral.ppressed) {
            pauser.setPause(-1);
            if (!pauser.paused){
            textgroup.hideText();
            }
            else {
                textgroup.showText("pausetxt");
            }
        }
    }

    public void resetLevel(){
        pauser.paused = false;
        player.reset();
        ghostGroup.reset();
        textgroup.showText("readytxt");
        pauser.setPause(-1);
    }

    public void nextlevel(){
        this.pelletGroup = new PelletGroup();
    resetLevel();
    }

    public void restartGame(){
        player.lives = 3;
        pauser.paused = false;
        startGame();
        textgroup.showText("gameovertxt");
    }

    void startGame(){
        //Set Key central
        keyCentral = new KeyCentral();
        //Set Sound
        sound = new Sound();
        //Set Tilemanager
        this.tileManager = new TileManager(this);
        //Set nodegroup
        nodeGroup = new NodeGroup("s");
        //Set Player
        player = new Player(this,keyCentral, (Node) nodeGroup.getStartTempNode());
        //Set PelletGroup
        this.pelletGroup = new PelletGroup();
        //Set EventChecker
        this.eventchecker = new Eventchecker(this);
        //Set Ghosts
        ghostGroup = new GhostGroup(this,keyCentral,nodeGroup,player);
        //Set Pauser
        pauser = new Pauser(false);
        pauser.setPause(-1);
        //Set Lives
        this.life = new Life(this);
        playSE(5);
    }
}