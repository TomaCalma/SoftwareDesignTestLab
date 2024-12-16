package entity;

import main.GamePanel;
import main.KeyCentral;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import position.Node;

public class BlinkyTest {
    GamePanel gamePanel;
    KeyCentral kc;

    Node node;

    Player player;

    @BeforeEach
    void init(){
        gamePanel= Mockito.mock(GamePanel.class);
        kc = Mockito.mock(KeyCentral.class);
        node = new Node(10,10);
        player = Mockito.mock(Player.class);
    }

    @Test
    void player(){
        new Blinky(gamePanel,kc,node,player);
    }
}
