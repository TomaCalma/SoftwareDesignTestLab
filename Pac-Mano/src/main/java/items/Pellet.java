package items;

import com.googlecode.lanterna.graphics.TextGraphics;
import helper.ColorConverter;
import position.Vector;

public class Pellet  {
    public Vector position;
    public int points;
    boolean visible;
    String[][] image;
    public int radius;
    public String name;

    Pellet(int row, int col) {
        this.position = new Vector(col * 16, row * 16);
        this.points = 10;
        this.visible = true;
        radius = 4;
        name = "PELLET";
        this.image = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "w", "w", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "w", "w", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };
    }

    void draw(TextGraphics graphics) {
        if (visible) {
            ColorConverter.draw(graphics, image, (int) position.x, (int) position.y);
        }
    }
}
