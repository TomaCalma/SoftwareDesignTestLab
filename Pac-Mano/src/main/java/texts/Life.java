package texts;

import com.googlecode.lanterna.graphics.TextGraphics;
import helper.ColorConverter;
import main.GamePanel;

import java.util.ArrayList;
import java.util.List;

public class Life {

    String [][] image;
    List<String [][]> images;

    GamePanel gp;

    public Life(GamePanel gp){
        this.gp = gp;
        getSprites();
        resetLives();
    }

    void getSprites() {
        image = new String[][]{
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

    public void removeImage(){
        if (images.size() > 0){
            images.remove(0);
        }
    }

    void resetLives(){
        images = new ArrayList<>();
        for (int i = 0 ; i<gp.player.lives; i++){
            images.add(image);
        }
    }

    public void draw(TextGraphics graphics){
        int size = 16;
        int x = 16*size;
        int y = 23*size-8;
        for (String[][] image : images){
            ColorConverter.draw(graphics,image,x,y);
            x += size;
        }
    }
}
