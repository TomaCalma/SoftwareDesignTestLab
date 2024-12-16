package main;

import com.googlecode.lanterna.input.KeyStroke;
import gamestates.MenuState;

public class KeyCentral {

    public boolean upPressed,downPressed,leftPressed,rightPressed,q2pressed,ppressed,pp0pressed,pp1pressed;


    void process(KeyStroke key,MenuState gs) {
        if (key.getCharacter() != null && gs == MenuState.GAME) {
            switch (key.getCharacter()) {
                case 'w':
                    upPressed = true;
                    break;
                case 's':
                    downPressed = true;
                    break;
                case 'a':
                    leftPressed = true;
                    break;
                case 'd':
                    rightPressed = true;
                    break;
                case 'q':
                    q2pressed = true;
                    break;
                case 'p':
                    ppressed = true;
                    break;
            }

        } else if (key.getCharacter() != null && gs == MenuState.MENU) {
            switch (key.getCharacter()) {
                case 'p':
                    pp0pressed = true;
                    break;
                case 'q':
                    pp1pressed = true;
                    break;
            }
        }
    }

            public void reset () {
                upPressed = false;
                downPressed = false;
                leftPressed = false;
                rightPressed = false;
                q2pressed = false;
                ppressed = false;
            }
    }
