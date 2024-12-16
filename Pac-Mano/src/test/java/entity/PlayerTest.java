package entity;

import main.GamePanel;
import main.KeyCentral;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import position.Node;

public class PlayerTest {

    GamePanel gamePanel;
    KeyCentral kc;

    Node node;

    Player player;

    @BeforeEach
    void init(){
        gamePanel= Mockito.mock(GamePanel.class);
        kc = Mockito.mock(KeyCentral.class);
        node = new Node(10,10);
        player = new Player(gamePanel,kc,node);
    }


    @Test
    void reset(){
        player.reset();
        Assertions.assertEquals("STOP",player.direction);
        Assertions.assertTrue(player.alive);
    }

    @Test
    void die(){
        player.die();
        Assertions.assertFalse(player.alive);
        Assertions.assertEquals("STOP",player.direction);
    }

    @Test
    void getValidKey(){
        kc.upPressed = true;
        Assertions.assertEquals("UP",player.getValidKey());
        kc.upPressed = false;

        kc.downPressed = true;
        Assertions.assertEquals("DOWN",player.getValidKey());
        kc.downPressed = false;

        kc.rightPressed = true;
        Assertions.assertEquals("RIGHT",player.getValidKey());
        kc.rightPressed = false;

        kc.leftPressed = true;
        Assertions.assertEquals("LEFT",player.getValidKey());

        kc.upPressed = false;
        kc.downPressed = false;
        kc.rightPressed = false;
        kc.leftPressed = false;

        Assertions.assertEquals("STOP",player.getValidKey());

    }

    @Test
    void validDirection(){
        String direction = "STOP";
        Assertions.assertFalse(player.validDirection(direction));
        // we are setting the direction to an arbitrary direction "UP"
        // because for testing purposes it doesnt matter the specific direction
        // as long as it is different from "STOP".
        direction = "UP";
        Assertions.assertFalse(player.validDirection(direction));
        node.neighbors.put("UP",new Node(0,1));
        Assertions.assertTrue(player.validDirection(direction));
    }



}
