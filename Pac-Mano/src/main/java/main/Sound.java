package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip[] soundClip = new Clip[6];
    URL[] soundURL = new URL[6];


    public  Sound() {
        soundURL[0] = getClass().getResource("/sounds/8bitmusic.wav");
        soundURL[1] = getClass().getResource("/sounds/munch_1.wav");
        soundURL[2] = getClass().getResource("/sounds/munch_2.wav");
        soundURL[3] = getClass().getResource("/sounds/death_1.wav");
        soundURL[4] = getClass().getResource("/sounds/eat_ghost.wav");
        soundURL[5] = getClass().getResource("/sounds/game_start.wav");
        setFiles();
    }

    public URL[] getSoundURL() {
        return soundURL;
    }

    public Clip getClip(int i) {
        return soundClip[i];
    }

    public void setFiles() {
        for (int i = 0 ; i< soundURL.length ; i++){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            soundClip[i] =AudioSystem.getClip();
            soundClip[i].open(ais);
        }catch (Exception e){
            System.out.println("No Audio");
        }
        }
    }
    public void loop(int i){
        soundClip[i].loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void play(int i){
        soundClip[i].setFramePosition(0);
        soundClip[i].start();
    }
    public void  stop(int i){
        soundClip[i].stop();
    }
}
