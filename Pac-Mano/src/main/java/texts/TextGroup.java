package texts;

import com.googlecode.lanterna.graphics.TextGraphics;
import main.GamePanel;

import java.util.HashMap;
import java.util.Map;

public class TextGroup {

    GamePanel gp;
    Map<String,Text> alltext;
    public TextGroup(GamePanel gp){
        this.gp=gp;
        alltext = new HashMap<>();
        setupText();
        showText("readytxt");
    }

    void update(){
        Map<String,Text> clone = alltext;
        for (String n : alltext.keySet()){
            alltext.get(n).update();
            if(alltext.get(n).destroy){
                clone.remove(n);
            }
        }
        alltext = clone;
    }
    void setupText(){
        int size = 16;
        alltext.put("scoretxt",new Text("00000000",1*size,23*16-4,-1,true));
        alltext.put("readytxt",new Text("press_p_to_start",6*size,23*size,-1,true));
        alltext.put("pressp",new Text("press_p_to_pause",6*size,22*size,-1,true));
        alltext.put("pausetxt",new Text("paused",8*size+8,23*size,-1,false));
        alltext.put("gameovertxt",new Text("you_lost_press_p_to_start_again",3*size,24*size,-1,false));
        alltext.put("score",new Text("score",1*size,22*size,-1,true));
        alltext.put("lifes",new Text("lifes",16*size,22*size,-1,true));
    }

    public void showText(String name){
        hideText();
        alltext.get(name).visible = true;
    }

    public void hideText(){
        alltext.get("readytxt").visible =false;
        alltext.get("pausetxt").visible =false;
        alltext.get("gameovertxt").visible =false;
    }

    public void updateScore(int score){
        updateText("scoretxt", String.valueOf(score));
    }

    void updateText(String scoretxt, String value) {
        if (alltext.containsKey(scoretxt)){
            alltext.get("scoretxt").setText(value);
        }
    }

    public void draw(TextGraphics graphics){
        for (Text t : alltext.values()){
            t.draw(graphics);
        }
    }
}
