package gamestates;

public class Pauser {

    public boolean paused;
    double timer;
    double pausetime;

    public Pauser(boolean paused){
        this.paused = paused;
        timer = 0;
        pausetime = 0;
    }

    public void update(){
        if (pausetime != -1){
            timer +=1;
            if (timer>=pausetime){
                timer=0;
                paused = false;
                pausetime = 0;
            }
        }
    }

    public void setPause(float pausetime){
        timer = 0;
        this.pausetime = pausetime;
        flip();
    }

    void flip(){
        paused = !paused;
    }
}
