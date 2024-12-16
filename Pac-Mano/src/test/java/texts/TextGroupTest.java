package texts;

import entity.Ghost;
import entity.Player;
import main.GamePanel;
import org.junit.jupiter.api.Test;


import main.GamePanel;
import main.KeyCentral;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
//import org.testng.assert.Assertion;
import position.Node;


public class TextGroupTest {
    GamePanel gamePanel;
    TextGroup textGroup;

    @BeforeEach
    void init() {
        gamePanel = Mockito.mock(GamePanel.class);
        textGroup = new TextGroup(gamePanel);
    }

   @Test
    public void showText(){
        textGroup.hideText();
        textGroup.showText("readytxt");
       textGroup.showText("pausetxt");
       textGroup.showText("gameovertxt");
       Assertions.assertEquals(false, textGroup.alltext.get("readytxt").visible);
       Assertions.assertEquals(false, textGroup.alltext.get("pausetxt").visible);
       Assertions.assertEquals(true, textGroup.alltext.get("gameovertxt").visible);
    }

    @Test
    void hideText(){
        textGroup.hideText();
        Assertions.assertEquals(false, textGroup.alltext.get("readytxt").visible);
        Assertions.assertEquals(false, textGroup.alltext.get("pausetxt").visible);
        Assertions.assertEquals(false, textGroup.alltext.get("gameovertxt").visible);

    }

    @Test
    void updateText(){
        textGroup.updateText("scoretxt", "123");

        Assertions.assertEquals("123", textGroup.alltext.get("scoretxt").text);
    }

    @Test
    void updateScore(){
        textGroup.updateScore(123);

        Assertions.assertEquals("123", textGroup.alltext.get("scoretxt").text);
    }

}
