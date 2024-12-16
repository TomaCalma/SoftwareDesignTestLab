package position;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import helper.ColorConverter;

import java.util.HashMap;
import java.util.Map;

public class Node {
    /*private final String[][] image;*/
    public Vector position;
    public Map<String,Node> neighbors;

    public Node(float x, float y){
        this.position = new Vector(x,y);
        this.neighbors = new HashMap<String,Node>();
        this.neighbors.put("UP",null);
        this.neighbors.put("DOWN",null);
        this.neighbors.put("LEFT",null);
        this.neighbors.put("RIGHT",null);
        this.neighbors.put("PORTAL",null);
        /*image = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "y", "y", "y", "y", "y", "y", "y", "y", "y", "", "", "", ""},
                {"", "", "", "y", "y", "", "", "", "", "", "y", "y", "", "", "", ""},
                {"", "", "", "y", "", "y", "", "", "", "y", "", "y", "", "", "", ""},
                {"", "", "", "y", "", "", "y", "", "y", "", "", "y", "", "", "", ""},
                {"", "", "", "y", "", "", "", "y", "", "", "", "y", "", "", "", ""},
                {"", "", "", "y", "", "", "y", "", "y", "", "", "y", "", "", "", ""},
                {"", "", "", "y", "", "y", "", "", "", "y", "", "y", "", "", "", ""},
                {"", "", "", "y", "y", "", "", "", "", "", "y", "y", "", "", "", ""},
                {"", "", "", "y", "", "", "", "", "", "", "y", "y", "", "", "", ""},
                {"", "", "", "y", "", "", "", "", "", "", "", "y", "", "", "", ""},
                {"", "", "", "y", "y", "y", "y", "y", "y", "y", "y", "y", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };*/
    }

    /*void draw(TextGraphics graphics){
        for(String key : neighbors.keySet()){
            if (neighbors.get(key) != null){
                TerminalPosition start = new TerminalPosition((int) position.x+8, (int) position.y+8);
                TerminalPosition end = new TerminalPosition((int) neighbors.get(key).position.x+8, (int) neighbors.get(key).position.y+8);
                graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
                graphics.drawLine(start,end, '⬛');
                ColorConverter.draw(graphics,image, (int) position.x, (int) position.y);
            }
        }
    }*/
}
