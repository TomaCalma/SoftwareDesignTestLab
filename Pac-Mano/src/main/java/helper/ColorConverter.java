package helper;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ColorConverter {

    //Function that decodes our way of demonstrating 8 bit characters;
    public static void draw(TextGraphics graphics,String[][] matrix,int x,int y){
        String yellow = "#FEE761";
        String orange = "#E4A672";
        String white = "#FFFFFF";
        String black = "#130E1D";
        String blue = "#2121DE";
        String red = "#F00000";
        String pink = "#FFB7FF";
        String ink = "#00FFFF";
        String green = "#00FF00";
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] .equals("y")){
                    graphics.setForegroundColor(TextColor.Factory.fromString(yellow));
                    graphics.putString(new TerminalPosition(x+j,y+i), "⬛");
                }
                if (matrix[i][j].equals("o")){
                    graphics.setForegroundColor(TextColor.Factory.fromString(orange));
                    graphics.putString(new TerminalPosition(x+j,y+i), "⬛");
                }
                if (matrix[i][j].equals("w")){
                    graphics.setForegroundColor(TextColor.Factory.fromString(white));
                    graphics.putString(new TerminalPosition(x+j,y+i), "⬛");
                }
                if (matrix[i][j].equals("b")){
                    graphics.setForegroundColor(TextColor.Factory.fromString(black));
                    graphics.putString(new TerminalPosition(x+j,y+i), "⬛");
                }
                if (matrix[i][j].equals("a")){
                    graphics.setForegroundColor(TextColor.Factory.fromString(blue));
                    graphics.putString(new TerminalPosition(x+j,y+i), "⬛");
                }
                if (matrix[i][j].equals("r")){
                    graphics.setForegroundColor(TextColor.Factory.fromString(red));
                    graphics.putString(new TerminalPosition(x+j,y+i), "⬛");
                }
                if (matrix[i][j].equals("p")){
                    graphics.setForegroundColor(TextColor.Factory.fromString(pink));
                    graphics.putString(new TerminalPosition(x+j,y+i), "⬛");
                }
                if (matrix[i][j].equals("i")){
                    graphics.setForegroundColor(TextColor.Factory.fromString(ink));
                    graphics.putString(new TerminalPosition(x+j,y+i), "⬛");
                }
                if(matrix[i][j].equals("g")){
                    graphics.setForegroundColor(TextColor.Factory.fromString(green));
                    graphics.putString(new TerminalPosition(x+j,y+i), "⬛");
                }
        }
    }
}
}
