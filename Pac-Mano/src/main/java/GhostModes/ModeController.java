package GhostModes;

import entity.Entity;

public class ModeController {
    Entity entity;
    double timer;
    
    double time;
    public String current = "RANDOM";

    public ModeController(Entity entity){
        this.timer = 0;
        this.time = 0;
        this.entity = entity;
    }

    public void update(){
        if (current.equals("FREIGHT")) {
            timer += 1;
            if (timer>=time){
                time = 0;
                this.entity.normalMode();
                this.current = "RANDOM";
            }
        }
        if (current.equals("FREEZE")) {
            timer += 1;
            if (timer>=time){
                time = 0;
                this.entity.normalMode();
                this.current = "RANDOM";
            }
        }
    }

    public void setFreightMode(){
        if (current.equals("RANDOM")){
            timer = 0;
            time = 140;
            current = "FREIGHT";
        } else if (current.equals("FREIGHT")) {
            timer = 0;
        }
    }

    public void setFreeze(){
        if (current.equals("FREIGHT")){
            timer = 0;
            time = 100;
            current = "FREEZE";
        } else if (current.equals("FREEZE")) {
            timer = 0;
        }
    }
}
