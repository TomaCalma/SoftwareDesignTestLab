package entity;

import main.GamePanel;
import main.KeyCentral;
import position.Node;

public class Blinky extends Ghost {
    public Blinky(GamePanel gp, KeyCentral kc, Node node, Player player) {
        super(gp, kc, node, player);
        getSprites();
    }

@Override    void getSprites() {
        right1 = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "r", "r", "r", "r", "", "", "", "", "", ""},
                {"", "", "", "", "r", "r", "r", "r", "r", "r", "r", "r", "", "", "", ""},
                {"", "", "", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "", "", ""},
                {"", "", "r", "r", "r", "w", "r", "r", "r", "r", "r", "r", "w", "r", "", ""},
                {"", "", "r", "r", "w", "w", "w", "r", "r", "r", "r", "w", "w", "w", "", ""},
                {"", "", "r", "r", "w", "w", "b", "b", "r", "r", "w", "w", "b", "b", "", ""},
                {"", "r", "r", "r", "w", "w", "b", "b", "r", "r", "w", "w", "b", "b", "r", ""},
                {"", "r", "r", "r", "r", "w", "w", "r", "r", "r", "r", "w", "w", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "", "r", "r", "r", "", "", "r", "r", "r", "", "r", "r", ""},
                {"", "r", "", "", "", "r", "r", "", "", "r", "r", "", "", "", "r", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        right2 = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "r", "r", "r", "r", "", "", "", "", "", ""},
                {"", "", "", "", "r", "r", "r", "r", "r", "r", "r", "r", "", "", "", ""},
                {"", "", "", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "", "", ""},
                {"", "", "r", "r", "r", "w", "r", "r", "r", "r", "r", "r", "w", "r", "", ""},
                {"", "", "r", "r", "w", "w", "w", "r", "r", "r", "r", "w", "w", "w", "", ""},
                {"", "", "r", "r", "w", "w", "b", "b", "r", "r", "w", "w", "b", "b", "", ""},
                {"", "r", "r", "r", "w", "w", "b", "b", "r", "r", "w", "w", "b", "b", "r", ""},
                {"", "r", "r", "r", "r", "w", "w", "r", "r", "r", "r", "w", "w", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "", "r", "r", "r", "r", "", "r", "r", "r", "r", ""},
                {"", "", "r", "r", "", "", "", "r", "r", "", "", "", "r", "r", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        left1 = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "r", "r", "r", "r", "", "", "", "", "", ""},
                {"", "", "", "", "r", "r", "r", "r", "r", "r", "r", "r", "", "", "", ""},
                {"", "", "", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "", "", ""},
                {"", "", "r", "w", "r", "r", "r", "r", "r", "r", "w", "r", "r", "r", "", ""},
                {"", "", "w", "w", "w", "r", "r", "r", "r", "w", "w", "w", "r", "r", "", ""},
                {"", "", "b", "b", "w", "w", "r", "r", "b", "b", "w", "w", "r", "r", "", ""},
                {"", "r", "b", "b", "w", "w", "r", "r", "b", "b", "w", "w", "r", "r", "r", ""},
                {"", "r", "r", "w", "w", "r", "r", "r", "r", "w", "w", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "", "r", "r", "r", "", "", "r", "r", "r", "", "r", "r", ""},
                {"", "r", "", "", "", "r", "r", "", "", "r", "r", "", "", "", "r", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        left2 = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "r", "r", "r", "r", "", "", "", "", "", ""},
                {"", "", "", "", "r", "r", "r", "r", "r", "r", "r", "r", "", "", "", ""},
                {"", "", "", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "", "", ""},
                {"", "", "r", "w", "r", "r", "r", "r", "r", "r", "w", "r", "r", "r", "", ""},
                {"", "", "w", "w", "w", "r", "r", "r", "r", "w", "w", "w", "r", "r", "", ""},
                {"", "", "b", "b", "w", "w", "r", "r", "b", "b", "w", "w", "r", "r", "", ""},
                {"", "r", "b", "b", "w", "w", "r", "r", "b", "b", "w", "w", "r", "r", "r", ""},
                {"", "r", "r", "w", "w", "r", "r", "r", "r", "w", "w", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "", "r", "r", "r", "r", "", "r", "r", "r", "r", ""},
                {"", "", "r", "r", "", "", "", "r", "r", "", "", "", "r", "r", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        up1 = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "r", "r", "r", "r", "", "", "", "", "", ""},
                {"", "", "", "", "b", "r", "r", "r", "r", "r", "r", "b", "", "", "", ""},
                {"", "", "", "w", "b", "b", "r", "r", "r", "r", "b", "b", "w", "", "", ""},
                {"", "", "r", "w", "w", "w", "w", "r", "r", "w", "w", "w", "w", "r", "", ""},
                {"", "", "r", "w", "w", "w", "w", "r", "r", "w", "w", "w", "w", "r", "", ""},
                {"", "", "r", "r", "w", "w", "r", "r", "r", "r", "w", "w", "r", "r", "", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "", "r", "r", "r", "", "", "r", "r", "r", "", "r", "r", ""},
                {"", "r", "", "", "", "r", "r", "", "", "r", "r", "", "", "", "r", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        up2 = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "r", "r", "r", "r", "", "", "", "", "", ""},
                {"", "", "", "", "b", "r", "r", "r", "r", "r", "r", "b", "", "", "", ""},
                {"", "", "", "w", "b", "b", "r", "r", "r", "r", "b", "b", "w", "", "", ""},
                {"", "", "r", "w", "w", "w", "w", "r", "r", "w", "w", "w", "w", "r", "", ""},
                {"", "", "r", "w", "w", "w", "w", "r", "r", "w", "w", "w", "w", "r", "", ""},
                {"", "", "r", "r", "w", "w", "r", "r", "r", "r", "w", "w", "r", "r", "", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "", "r", "r", "r", "r", "", "r", "r", "r", "r", ""},
                {"", "", "r", "r", "", "", "", "r", "r", "", "", "", "r", "r", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        down1 = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "r", "r", "r", "r", "", "", "", "", "", ""},
                {"", "", "", "", "b", "r", "r", "r", "r", "r", "r", "b", "", "", "", ""},
                {"", "", "", "w", "b", "b", "r", "r", "r", "r", "b", "b", "w", "", "", ""},
                {"", "", "r", "w", "w", "w", "w", "r", "r", "w", "w", "w", "w", "r", "", ""},
                {"", "", "r", "r", "w", "r", "r", "r", "r", "r", "r", "w", "r", "r", "", ""},
                {"", "", "r", "w", "w", "w", "r", "r", "r", "r", "w", "w", "w", "r", "", ""},
                {"", "r", "r", "w", "w", "w", "w", "r", "r", "w", "w", "w", "w", "r", "r", ""},
                {"", "r", "r", "w", "b", "b", "w", "r", "r", "w", "b", "b", "w", "r", "r", ""},
                {"", "r", "r", "r", "b", "b", "r", "r", "r", "r", "b", "b", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "", "r", "r", "r", "", "", "r", "r", "r", "", "r", "r", ""},
                {"", "r", "", "", "", "r", "r", "", "", "r", "r", "", "", "", "r", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        down2 = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "r", "r", "r", "r", "", "", "", "", "", ""},
                {"", "", "", "", "r", "r", "r", "r", "r", "r", "r", "r", "", "", "", ""},
                {"", "", "", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "", "", ""},
                {"", "", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "", ""},
                {"", "", "r", "r", "w", "r", "r", "r", "r", "r", "r", "w", "r", "r", "", ""},
                {"", "", "r", "w", "w", "w", "r", "r", "r", "r", "w", "w", "w", "r", "", ""},
                {"", "r", "r", "w", "w", "w", "w", "r", "r", "w", "w", "w", "w", "r", "r", ""},
                {"", "r", "r", "w", "b", "b", "w", "r", "r", "w", "b", "b", "w", "r", "r", ""},
                {"", "r", "r", "r", "b", "b", "r", "r", "r", "r", "b", "b", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", ""},
                {"", "r", "r", "r", "r", "", "r", "r", "r", "r", "", "r", "r", "r", "r", ""},
                {"", "", "r", "r", "", "", "", "r", "r", "", "", "", "r", "r", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };

        freight = new String[][]{
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "a", "a", "a", "a", "", "", "", "", "", ""},
                {"", "", "", "", "a", "a", "a", "a", "a", "a", "a", "a", "", "", "", ""},
                {"", "", "", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "", "", ""},
                {"", "", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "", ""},
                {"", "", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "", ""},
                {"", "", "a", "a", "a", "w", "w", "a", "a", "w", "w", "a", "a", "a", "", ""},
                {"", "a", "a", "a", "a", "w", "w", "a", "a", "w", "w", "a", "a", "a", "a", ""},
                {"", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", ""},
                {"", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", ""},
                {"", "a", "a", "w", "w", "a", "w", "w", "a", "a", "w", "w", "a", "a", "a", ""},
                {"", "a", "w", "a", "a", "w", "a", "a", "w", "w", "a", "a", "w", "a", "a", ""},
                {"", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", ""},
                {"", "a", "a", "a", "a", "", "a", "a", "a", "a", "", "a", "a", "a", "a", ""},
                {"", "", "a", "a", "", "", "", "a", "a", "", "", "", "a", "a", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        };
    }
}