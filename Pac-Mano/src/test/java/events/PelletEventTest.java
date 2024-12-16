package events;

import main.GamePanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PelletEventTest {
    @Test
    void pelletEvent(){
        GamePanel gamePanel = Mockito.mock(GamePanel.class);
        PelletEvent eventchecker = new PelletEvent(gamePanel);

        Assertions.assertEquals(1,eventchecker.currSound);
    }
}

