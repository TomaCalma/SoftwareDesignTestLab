package items;

import com.googlecode.lanterna.graphics.TextGraphics;
import helper.ColorConverter;
import position.Vector;

public class PowerPellet extends Pellet {

    PowerPellet(int row, int col) {
        super(row,col);
        this.position = new Vector(col * 16, row * 16);
        this.points = 50;
        radius = 8;
        name = "POWERPELLET";
        this.image = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "w", "w", "w", "w", "w", "w", "", "", "", "", ""},
                {"", "", "", "", "", "w", "w", "w", "w", "w", "w", "", "", "", "", ""},
                {"", "", "", "", "", "w", "w", "w", "w", "w", "w", "", "", "", "", ""},
                {"", "", "", "", "", "w", "w", "w", "w", "w", "w", "", "", "", "", ""},
                {"", "", "", "", "", "w", "w", "w", "w", "w", "w", "", "", "", "", ""},
                {"", "", "", "", "", "w", "w", "w", "w", "w", "w", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };
    }

}