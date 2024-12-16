package entity;

import com.googlecode.lanterna.graphics.TextGraphics;
import helper.ColorConverter;
import items.Pellet;
import main.GamePanel;
import main.KeyCentral;
import position.Node;
import position.Vector;

import java.util.List;

public class Player extends Entity {
    KeyCentral kc;
    public boolean alive =true;
    public int lives;
    public int score;

    int spriteCounter = 0;
    int spriteNum = 1;
    public Player(GamePanel gp, KeyCentral kc, Node node){
        super(gp,kc,node);
        this.kc = kc;
        this.speed = 4;
        getSprites();
        direction = "LEFT";
        lives = 3;
        score = 0;
    }

@Override    public void reset(){
        super.reset();
        direction = "STOP";
        alive = true;
    }

    public void die(){
        alive = false;
        direction = "STOP";
    }

    void getSprites(){
        up1 = new String[][]{
                {"", "", "", "", "", "", "  ", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "w", "o", "", ""},
                {"", "", "o", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", "", ""},
                {"", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "w", "o", ""},
                {"", "o", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", ""},
                {"", "o", "y", "y", "b", "b", "y", "y", "y", "y", "y", "y", "y", "y", "o", ""},
                {"", "o", "w", "y", "w", "w", "y", "y", "y", "y", "y", "y", "y", "w", "o", ""},
                {"", "", "o", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", "", ""},
                {"", "", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        up2 = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "o", "o", "", "", "", "", "o", "o", "", "", "", ""},
                {"", "", "", "o", "w", "o", "", "", "", "", "o", "w", "o", "", "", ""},
                {"", "", "o", "w", "y", "w", "o", "", "", "o", "w", "y", "w","o", "", ""},
                {"", "", "o", "y", "y", "y", "o", "", "", "o", "y", "y", "y", "o", "", ""},
                {"", "o", "w", "y", "y", "y", "w", "o", "o", "w", "y", "y", "y", "w", "o", ""},
                {"", "o", "y", "y", "y", "y", "y", "w", "w", "y", "y", "y", "y", "y", "o", ""},
                {"", "o", "y", "y", "b", "b", "y", "y", "y", "y", "y", "y", "y", "y", "o", ""},
                {"", "o", "w", "y", "w", "w", "y", "y", "y", "y", "y", "y", "y", "w", "o", ""},
                {"", "", "o", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", "", ""},
                {"", "", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "w", "o", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        down1 = new String[][]{
                {"", "", "", "", "", "", "  ", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", "", ""},
                {"", "", "o", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", "", ""},
                {"", "o", "w", "y", "y", "y", "y", "y", "y", "y", "w", "w", "y", "w", "o", ""},
                {"", "o", "y", "y", "y", "y", "y", "y", "y", "y", "b", "b", "y", "y", "o", ""},
                {"", "o", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", ""},
                {"", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "w", "o", ""},
                {"", "", "o", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", "", ""},
                {"", "", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "w", "o", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        down2 = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "w", "o", "", ""},
                {"", "", "o", "y", "y", "y", "y", "y", "y", "y", "y", "y", "y", "o", "", ""},
                {"", "o", "y", "y", "y", "y", "y", "y", "y", "y", "w", "w", "y", "y", "o", ""},
                {"", "o", "y", "y", "y", "y", "y", "y", "y", "y", "b", "b", "y", "y", "o", ""},
                {"", "o", "y", "y", "y", "y", "y", "w", "w", "y", "y", "y", "y", "y", "o", ""},
                {"", "o", "w", "y", "y", "y", "w", "o", "o", "w", "y", "y", "y", "w", "o", ""},
                {"", "", "o", "y", "y", "y", "o", "", "", "o", "y", "y", "y", "o", "", ""},
                {"", "", "o", "w", "y", "w", "o", "", "", "o", "w", "y", "w","o", "", ""},
                {"", "", "", "o", "w", "o", "", "", "", "", "o", "w", "o", "", "", ""},
                {"", "", "", "", "o", "o", "", "", "", "", "o", "o", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        left1 = new String[][]{
                {"", "", "", "", "", "", "  ", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "o", "w", "y", "y", "y", "y", "b", "w", "y", "y", "y", "o", "", ""},
                {"", "", "o", "y", "y", "y", "y", "y", "b", "w", "y", "y", "y", "o", "", ""},
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
        left2 = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "o", "w", "y", "y", "y", "y", "b", "w", "y", "y", "y", "o", "", ""},
                {"", "", "o", "o", "w", "y", "y", "y", "b", "w", "y", "y", "y", "o", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", ""},
                {"", "", "", "", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "o", ""},
                {"", "", "", "", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "o", ""},
                {"", "", "", "", "o", "o", "y", "y", "y", "y", "y", "y", "y", "w", "o", ""},
                {"", "", "o", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "o", "", ""},
                {"", "", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "w", "o", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

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
        right2 = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "y", "o", "o", "", "", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "o", "w", "y", "y", "w", "b", "y", "y", "y", "y", "w", "o", "", ""},
                {"", "", "o", "y", "y", "y", "w", "b", "y", "y", "y", "w", "o", "o", "", ""},
                {"", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "o", "y", "y", "y", "y", "y", "y", "w", "o", "", "", "", "", "", ""},
                {"", "o", "y", "y", "y", "y", "y", "y", "w", "o", "", "", "", "", "", ""},
                {"", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "o", "y", "y", "y", "y", "y", "y", "y", "y", "w", "o", "o", "", ""},
                {"", "", "o", "w", "y", "y", "y", "y", "y", "y", "y", "y", "w", "o", "", ""},
                {"", "", "", "o", "w", "y", "y", "y", "y", "y", "y", "w", "o", "", "", ""},
                {"", "", "", "", "o", "o", "w", "y", "y", "w", "o", "o", "", "", "", ""},
                {"", "", "", "", "", "", "o", "o", "o", "o", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };
    }

@Override    public void update(){
        this.position = position.add(directions.get(direction).mul(speed));
        String ndirection = getValidKey();
        if (overshotTarget()){
            node = target;
            target=getNewTarget(ndirection);
            if (!(node.neighbors.get("PORTAL") == null)){
                node = node.neighbors.get("PORTAL");
                target=getNewTarget(ndirection);
            }
            if (!target.equals(node)){
                this.direction=ndirection;
            }
            else {
                direction = "STOP";
            }
            setPosition();
        }
        spriteCounter++;
        if (spriteCounter > 7) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
    }
    }

@Override    public void draw(TextGraphics graphics){
        String[][] image = null;
        switch (direction) {
            case "UP": {
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
            }break;
            case "DOWN": {
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
            }break;
            case "LEFT": {
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
            }break;
            case "RIGHT":
            case "STOP": {
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
            }break;
        }

        assert image != null;
        ColorConverter.draw(graphics,image, (int) position.x, (int) position.y);    }

    String getValidKey(){
        if (kc.upPressed) {
            return "UP";
        }
        if (kc.downPressed) {
            return "DOWN";
        }
        if (kc.leftPressed) {
            return "LEFT";
        }
        if (kc.rightPressed) {
            return "RIGHT";
        }
        return "STOP";
    }

@Override    void setPosition(){
        position = node.position.copy();
    }

@Override    boolean validDirection(String direction){
     if (!direction.equals("STOP")){
         return node.neighbors.get(direction) != null;
     }
     return false;
    }

@Override    Node getNewTarget(String direction){
        if (validDirection(direction)){
            return node.neighbors.get(direction);
        }
        return node;
    }

@Override    boolean overshotTarget(){
        if (this.target != null){
            Vector vec1 = target.position.sub(node.position);
            Vector vec2 = this.position.sub(node.position);
            float node2Target = vec1.magnitudeSquared();
            float node2Self =vec2.magnitudeSquared();
            return node2Self>=node2Target;
        }
        return false;
    }

    public Pellet eatPellets(List<Pellet> pelletList){
        for (Pellet pellet : pelletList){
            if (collideCheck(pellet)){
                return pellet;
            }
        }
        return null;
    }

    public boolean collideGhost(Ghost ghost){
        return collideCheck(ghost);
    }

    boolean collideCheck(Entity other){
        Vector d = position.sub(other.position);
        float dSquared = d.magnitudeSquared();
        float rSquared = (other.radius+collideRadius)*(other.radius+collideRadius);
        if (dSquared<= rSquared){
            return true;
        }
        return false;
    }

    boolean collideCheck(Pellet other){
        Vector d = position.sub(other.position);
        float dSquared = d.magnitudeSquared();
        float rSquared = (other.radius+collideRadius)*(other.radius+collideRadius);
        if (dSquared<= rSquared){
            return true;
        }
        return false;
    }
    public void updateScore(int points){
        score += points;
        gp.textgroup.updateScore(score);
    }
}
