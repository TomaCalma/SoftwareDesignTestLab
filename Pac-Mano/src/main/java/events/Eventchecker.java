package events;

import entity.Ghost;
import main.GamePanel;

public class Eventchecker {

    GamePanel gp;
    public static PelletEvent pelletEvent;

    public static GhostEvent ghostEvent;

    public Eventchecker(GamePanel gp){
        this.gp = gp;
        pelletEvent = new PelletEvent(gp);
        ghostEvent = new GhostEvent(gp);
    }

    public static void checkEvents(){
        pelletEvent.checkPelletEvent();
        ghostEvent.checkGhostEvent();
    }
}
