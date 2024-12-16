package entity;

import main.GamePanel;
import main.KeyCentral;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import position.Node;

public class GhostTest {
    GamePanel gamePanel;
    KeyCentral kc;
    Node node;
    Player player;
    Ghost ghost;

    @BeforeEach
    void init() {
        gamePanel = Mockito.mock(GamePanel.class);
        kc = Mockito.mock(KeyCentral.class);
        node = new Node(10, 10);
        player = Mockito.mock(Player.class);
        ghost = new Ghost(gamePanel, kc, node, player);
    }

    @Test
    void reset() {
        ghost.reset();
        Assertions.assertEquals(200, ghost.points);
    }

    @Test
    void normalMode(){
        ghost.normalMode();
        Assertions.assertEquals(3, ghost.speed);
    }

    @Test
    void startFreight(){
        ghost.startFreight();
        Assertions.assertEquals(1, ghost.speed);
    }

}
