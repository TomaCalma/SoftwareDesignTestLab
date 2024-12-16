package entity;

import com.googlecode.lanterna.graphics.TextGraphics;
import helper.ColorConverter;
import main.GamePanel;
import main.KeyCentral;
import position.Node;
import position.Vector;

import java.util.*;

public class Entity {
    GamePanel gp;
    Vector position;
    Map<String,Vector> directions;
    String direction;
    Node node;
    Node spawnNode;
    Node target;

    Vector goal;
    int speed;

    int radius;
    int collideRadius;
    public boolean visible;
    boolean disablePortal ;
    public String[][] up1,up2,down1,down2,left1,left2,right1,right2,freight;

    Entity(GamePanel gp, KeyCentral kc, Node node){
        this.gp = gp ;
        this.node = node;
        this.spawnNode = node;
        directions = new HashMap<String,Vector>();
        directions.put("STOP",new Vector(0,0));
        directions.put("UP",new Vector(0,-1));
        directions.put("DOWN",new Vector(0,1));
        directions.put("LEFT",new Vector(-1,0));
        directions.put("RIGHT",new Vector(1,0));
        direction = "STOP";
        target = node;
        speed = 3;
        radius = 10;
        collideRadius = 5;
        setPosition();
        visible = true;
        disablePortal = false;
        goal = null;
    }

    public void reset(){
        node = spawnNode;
        target = node;
        setPosition();
        speed = 4;
        visible = true;
    }

    void setPosition(){
        position = node.position.copy();
    }

    boolean validDirection(String direction){
        if (!direction.equals("STOP")){
            return node.neighbors.get(direction) != null;
        }
        return false;
    }

    Node getNewTarget(String direction){
        if (validDirection(direction)){
            return node.neighbors.get(direction);
        }
        return node;
    }

    boolean overshotTarget(){
        if (this.target != null){
            Vector vec1 = target.position.sub(node.position);
            Vector vec2 = this.position.sub(node.position);
            float node2Target = vec1.magnitudeSquared();
            float node2Self =vec2.magnitudeSquared();
            return node2Self>=node2Target;
        }
        return false;
    }

    public void draw(TextGraphics graphics){
        ColorConverter.draw(graphics,right1, (int) position.x, (int) position.y);
    }

    List<String> validDirections(){
        List<String> ldirections = new ArrayList<>();
        String rdirection = null;
        switch (direction){
            case "UP" :rdirection = "DOWN"; break;
            case "DOWN" :rdirection = "UP"; break;
            case "LEFT" :rdirection = "RIGHT"; break;
            case "RIGHT" :rdirection = "LEFT"; break;
            case "STOP" :rdirection = "STOP"; break;
        }
        List<String> d = new ArrayList<>();
        d.add("UP");
        d.add("DOWN");
        d.add("LEFT");
        d.add("RIGHT");
        for (String key : d){
            if (validDirection(key)){
                if(!key.equals(rdirection)){
                    ldirections.add(key);
                }
            }
        }
        if (ldirections.isEmpty()){
            ldirections.add(rdirection);
        }
        return ldirections;
    }

    String randomDirection(List<String> ldirections){
        int r = new Random().nextInt(ldirections.size());
        return ldirections.get(r);
    }

    String goalDirection(List<String> directions){
        List<Float> distances = new ArrayList<>();
        for (String direction : directions){
            Vector vec = node.position.add(this.directions.get(direction)).mul(16).sub(goal);
            distances.add(vec.magnitudeSquared());
        }
        int index = distances.indexOf(Collections.min(distances));
        return directions.get(index);
    }

    public void update(){
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

    public void normalMode() {
        speed = 10;
    }
}

