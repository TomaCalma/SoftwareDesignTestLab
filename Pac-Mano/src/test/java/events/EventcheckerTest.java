package events;

import entity.GhostGroup;
import entity.Player;
import items.PelletGroup;
import main.GamePanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class EventcheckerTest {
    @Test
    void checkevents(){
        GamePanel gamePanel = Mockito.mock(GamePanel.class);
        Eventchecker eventchecker = new Eventchecker(gamePanel);
    }
}
