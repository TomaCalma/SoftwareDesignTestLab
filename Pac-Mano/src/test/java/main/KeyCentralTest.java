package main;


import gamestates.MenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.*;


public class KeyCentralTest {


    @Test
    void process(){
        KeyCentral keyCentral = new KeyCentral();
        KeyStroke key = Mockito.mock(KeyStroke.class);
        MenuState gs = MenuState.GAME;

        Mockito.when(key.getCharacter()).thenReturn('w');
        keyCentral.process(key,gs);
        Assertions.assertEquals(true,keyCentral.upPressed);

        Mockito.when(key.getCharacter()).thenReturn('s');
        keyCentral.process(key,gs);
        Assertions.assertEquals(true,keyCentral.downPressed);

        Mockito.when(key.getCharacter()).thenReturn('a');
        keyCentral.process(key,gs);
        Assertions.assertEquals(true,keyCentral.leftPressed);

        Mockito.when(key.getCharacter()).thenReturn('d');
        keyCentral.process(key,gs);
        Assertions.assertEquals(true,keyCentral.rightPressed);

        Mockito.when(key.getCharacter()).thenReturn('p');
        keyCentral.process(key,gs);
        Assertions.assertEquals(true,keyCentral.ppressed);

        Mockito.when(key.getCharacter()).thenReturn('q');
        keyCentral.process(key,gs);
        Assertions.assertEquals(true,keyCentral.q2pressed);

        gs = MenuState.MENU;

        Mockito.when(key.getCharacter()).thenReturn('p');
        keyCentral.process(key,gs);
        Assertions.assertEquals(true,keyCentral.pp0pressed);

        Mockito.when(key.getCharacter()).thenReturn('q');
        keyCentral.process(key,gs);
        Assertions.assertEquals(true,keyCentral.pp1pressed);

    }

    @Test
    void reset(){
        KeyCentral keyCentral = new KeyCentral();
        keyCentral.reset();
        Assertions.assertFalse(keyCentral.upPressed);
        Assertions.assertFalse(keyCentral.downPressed);
        Assertions.assertFalse(keyCentral.leftPressed);
        Assertions.assertFalse(keyCentral.rightPressed);
        Assertions.assertFalse(keyCentral.q2pressed);
        Assertions.assertFalse(keyCentral.ppressed);
    }

}
