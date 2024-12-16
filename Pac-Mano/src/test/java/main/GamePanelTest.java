/*package main;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class GamePanelTest {

    GamePanel gamePanel;
    Thread gameThread;


    @BeforeEach
    void Init() throws IOException, URISyntaxException, FontFormatException {
        gamePanel = Mockito.mock(GamePanel.class);
        gameThread = Mockito.mock(Thread.class);
        Mockito.when(gamePanel.gameThread).thenReturn(gameThread);
        //Mockito.mock(GamePanel.class);
    }

    @Test
    void GamePanel(){
        gamePanel.startGameThread();
        Mockito.verify(gamePanel.gameThread,times(1)).start();
    }




    /*@Test
    void startGameThread(){
        verify(gameThread);
    }


}

/*
 */



