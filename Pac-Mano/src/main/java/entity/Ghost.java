package entity;

import GhostModes.ModeController;
import com.googlecode.lanterna.graphics.TextGraphics;
import helper.ColorConverter;
import main.GamePanel;
import main.KeyCentral;
import position.Node;
import position.Vector;

import java.util.List;

public class Ghost extends Entity{

    public ModeController mode;
    Player player;
    public int points;

    public Ghost(GamePanel gp, KeyCentral kc, Node node , Player player) {
        super(gp, kc, node);
        this.points = 200;
        this.goal = new Vector(1,1);
        this.disablePortal = true;
        getSprites();
        this.player = player;
        this.mode = new ModeController(this);
        this.spawnNode = node;
    }

@Override    public void reset(){
        super.reset();
        points =200;
    }

    void getSprites(){
        right1 = new String[][]{
                {"", "", "", "", "", "", "  ", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "o", "w", "y", "y", "w", "b", "y", "y", "y", "y", "y", "o", "", ""},
                {"", "", "o", "y", "y", "y", "w", "b", "y", "y", "y", "y", "y", "o", "", ""},
                {"", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "w", "o", ""},
                {"", "o", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", ""},
                {"", "o", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", ""},
                {"", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "w", "o", ""},
                {"", "", "o", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", "", ""},
                {"", "", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "w", "o", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };
    }

@Override    public void update(){
        mode.update();
        position = position.add(directions.get(direction).mul(speed));
        if (overshotTarget()){
            node = target;
            List<String> ldirections = validDirections();
            String ndirection = randomDirection(ldirections);
            if (!disablePortal){
                if(!(node.neighbors.get("PORTAL") == null)){
                    node = node.neighbors.get("PORTAL");
                }
            }
            target = getNewTarget(ndirection);
            if (!target.equals(node)){
                direction = ndirection;
            }
            else{
                target = getNewTarget(direction);
            }
            setPosition();
        }
    }

@Override    public void  normalMode(){
        speed = 3;
    }

    public void startFreight(){
        mode.setFreightMode();
        if (mode.current.equals("FREIGHT")){
            speed = 1;
        }
    }

    public void startFreeze(){
        mode.setFreeze();
        if (mode.current.equals("FREEZE")){
            speed = 0;
        }
    }

    public void spawn(){
        node = spawnNode;
        setPosition();
        startFreeze();
    }

@Override    public void draw(TextGraphics graphics){
        if (mode.current.equals("FREIGHT")){
        ColorConverter.draw(graphics,freight, (int) position.x, (int) position.y);}
        else {
            ColorConverter.draw(graphics,right1, (int) position.x, (int) position.y);}
    }

}
