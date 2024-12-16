package items;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class PelletGroup {

    public List<Pellet> pelletList = new ArrayList<>();
    List<Pellet> powerpellets = new ArrayList<>();

    List<Object> pelletsymbols;
    List<Object> powersymbols;

    public int numEaten=0;


    public PelletGroup() {
        String[][] data = readMazeString();
        pelletsymbols = new ArrayList<>();
        pelletsymbols.add(".");
        pelletsymbols.add("#");
        powersymbols = new ArrayList<>();
        powersymbols.add("p");
        createPelletList(data);
    }

    String[][] readMazeString() {
        return new String[][]{
                {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "#", ".", ".", "#", ".", ".", ".", "#", "X", "#", ".", ".", ".", "#", ".", ".", "#", "X"},
                {"X", "p", "X", "X", ".", "X", "X", "X", ".", "X", ".", "X", "X", "X", ".", "X", "X", "p", "X"},
                {"X", ".", "X", "X", ".", "X", "X", "X", ".", "X", ".", "X", "X", "X", ".", "X", "X", ".", "X"},
                {"X", "#", ".", ".", "#", ".", "#", ".", "#", ".", "#", ".", "#", ".", "#", ".", ".", "#", "X"},
                {"X", ".", "X", "X", ".", "X", ".", "X", "X", "X", "X", "X", ".", "X", ".", "X", "X", ".", "X"},
                {"X", "#", ".", ".", "#", "X", "#", ".", "#", "X", "#", ".", "#", "X", "#", ".", ".", "#", "X"},
                {"X", "X", "X", "X", ".", "X", "X", "X", "-", "X", "-", "X", "X", "X", ".", "X", "X", "X", "X"},
                {"X", "X", "X", "X", ".", "X", "-", "-", "-", "-", "-", "-", "-", "X", ".", "X", "X", "X", "X"},
                {"X", "X", "X", "X", ".", "X", "-", "X", "X", "-", "X", "X", "-", "X", ".", "X", "X", "X", "X"},
                {"#", "#", ".", ".", "#", "-", "-", "X", "-", "-", "-", "X", "-", "-", "#", ".", ".", "#", "#"},
                {"X", "X", "X", "X", ".", "X", "-", "X", "X", "X", "X", "X", "-", "X", ".", "X", "X", "X", "X"},
                {"X", "X", "X", "X", ".", "X", "-", "-", "-", "-", "-", "-", "-", "X", ".", "X", "X", "X", "X"},
                {"X", "X", "X", "X", ".", "X", "-", "X", "X", "X", "X", "X", "-", "X", ".", "X", "X", "X", "X"},
                {"X", "#", ".", ".", "#", ".", "#", ".", "#", "X", "#", ".", "#", ".", "#", ".", ".", "#", "X"},
                {"X", ".", "X", "X", ".", "X", "X", "X", ".", "X", ".", "X", "X", "X", ".", "X", "X", ".", "X"},
                {"X", "p", "#", "X", "#", ".", "#", ".", "#", "-", "#", ".", "#", ".", "#", "X", "#", "p", "X"},
                {"X", "X", ".", "X", ".", "X", ".", "X", "X", "X", "X", "X", ".", "X", ".", "X", ".", "X", "X"},
                {"X", "#", "#", ".", "#", "X", "#", ".", "#", "X", "#", ".", "#", "X", "#", ".", "#", "#", "X"},
                {"X", ".", "X", "X", "X", "X", "X", "X", ".", "X", ".", "X", "X", "X", "X", "X", "X", ".", "X"},
                {"X", "#", ".", ".", ".", ".", ".", ".", "#", ".", "#", ".", ".", ".", ".", ".", ".", "#", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"},
        };
    }

    void createPelletList(String[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++) {
                if(pelletsymbols.contains(data[row][col])){
                    pelletList.add(new Pellet(row,col));
                } else if (powersymbols.contains(data[row][col])) {
                    Pellet pp = new PowerPellet(row,col);
                    pelletList.add(pp);
                    powerpellets.add(pp);
                }
            }
        }
    }

    public void draw(TextGraphics graphics){
        for (Pellet p : pelletList){
            p.draw(graphics);
        }
    }

}