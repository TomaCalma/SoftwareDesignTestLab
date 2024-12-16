package events;

import entity.Ghost;
import main.GamePanel;

public class GhostEvent {
    GamePanel gp;

    GhostEvent(GamePanel gp){
        this.gp = gp;
    }

    void checkGhostEvent(){
        for (Ghost g : gp.ghostGroup.ghosts){
            if (gp.player.collideGhost(g)){
                if (g.mode.current.equals("FREIGHT")){
                    gp.player.updateScore(g.points);
                    g.spawn();
                    gp.playSE(4);
                }
                if (g.mode.current.equals("RANDOM")){
                    if(gp.player.alive){
                        gp.player.lives -= 1;
                        gp.life.removeImage();
                        gp.player.die();
                        gp.pauser.setPause(80);
                        gp.ghostGroup.hide();
                        if (gp.player.lives<= 0){
                            gp.restartGame();
                        }
                        else {
                            gp.resetLevel();
                        }
                        gp.playSE(3);
                    }
                }
            }
        }
    }
}
