package entity;

import com.googlecode.lanterna.graphics.TextGraphics;
import main.GamePanel;
import main.KeyCentral;
import position.Node;
import position.NodeGroup;

import java.util.ArrayList;
import java.util.List;

public class GhostGroup {
    Blinky blinky;
    Pinky pinky;
    Inky inky;
    Clyde clyde;
    public List<Ghost> ghosts =new ArrayList<>();


    public GhostGroup(GamePanel gp, KeyCentral kc, NodeGroup nodeGroup, Player player){
        blinky = new Blinky(gp,kc, (Node) nodeGroup.getStartTempNodeBlinky(),player);
        pinky = new Pinky(gp,kc, (Node) nodeGroup.getStartTempNodePinky(),player);
        inky = new Inky(gp,kc, (Node) nodeGroup.getStartTempNodeInky(),player);
        clyde = new Clyde(gp,kc, (Node) nodeGroup.getStartTempNodeClyde(),player);
        ghosts.add(blinky);
        ghosts.add(pinky);
        ghosts.add(inky);
        ghosts.add(clyde);
    }

    public void update(){
        for (Ghost g : ghosts){
            g.update();
        }
    }

    public void startFreight(){
        for (Ghost g : ghosts){
            g.startFreight();
        }
        resetPoints();
    }

    void updatePoints(){
        for (Ghost g : ghosts){
            g.points *=2;
        }
    }

    void resetPoints(){
        for (Ghost g : ghosts){
            g.points = 200;
        }
    }

    public void reset(){
        for (Ghost g : ghosts){
            g.reset();
        }
    }

    public void hide(){
        for (Ghost g : ghosts){
            g.visible = false;
        }
    }

    public void show(){
        for (Ghost g : ghosts){
            g.visible = true;
        }
    }

    public void draw(TextGraphics graphics){
        for (Ghost g : ghosts){
            g.draw(graphics);
        }
    }
}
