package events;

import items.Pellet;
import main.GamePanel;

public class PelletEvent {
    GamePanel gp;

    int currSound = 1;

    PelletEvent(GamePanel gp){
        this.gp = gp;
    }

    void checkPelletEvent(){
        switch (currSound){
            case 1: currSound=2;
            break;
            case 2: currSound=1;
            break;
        }
        Pellet pellet = gp.player.eatPellets(gp.pelletGroup.pelletList);
        if (pellet!=null){
            gp.playSE(currSound);
            gp.pelletGroup.numEaten += 1;
            gp.pelletGroup.pelletList.remove(pellet);
            gp.player.updateScore(pellet.points);
            System.out.println(gp.pelletGroup.numEaten);
            if (gp.pelletGroup.numEaten >= 164 ){
                gp.nextlevel();
            }
            if (pellet.name.equals("POWERPELLET")){
                gp.ghostGroup.startFreight();
            }
        }
    }
}
