package midifckn;

import java.io.File;
import javafx.scene.media.AudioClip;
//import javafx.stage.FileChooser;


public class SoundModel {
    
    //1st Row Sound
    private AudioClip s0 = new AudioClip(new File("src\\midifckn\\soundFiles\\808Blaster.wav").toURI().toString());
    private AudioClip s1 = new AudioClip(new File("src\\midifckn\\soundFiles\\808Kick2.wav").toURI().toString());
    private AudioClip s2 = new AudioClip(new File("src\\midifckn\\soundFiles\\snareDry.wav").toURI().toString());
    private AudioClip s3 = new AudioClip(new File("src\\midifckn\\soundFiles\\snareCrusher.wav").toURI().toString());
    private AudioClip s4 = new AudioClip(new File("src\\midifckn\\soundFiles\\snareBamboo.wav").toURI().toString());
    //2nd Row Sound
    private AudioClip s5 = new AudioClip(new File("src\\midifckn\\soundFiles\\808Kick.wav").toURI().toString());
    private AudioClip s6 = new AudioClip(new File("src\\midifckn\\soundFiles\\808Kick4D#.wav").toURI().toString());
    private AudioClip s7 = new AudioClip(new File("src\\midifckn\\soundFiles\\808KickE.wav").toURI().toString());
    private AudioClip s8 = new AudioClip(new File("src\\midifckn\\soundFiles\\snareSoft.wav").toURI().toString());
    private AudioClip s9 = new AudioClip(new File("src\\midifckn\\soundFiles\\snareLoud.wav").toURI().toString());
   //3rd Row Sound
    private AudioClip s10 = new AudioClip(new File("src\\midifckn\\soundFiles\\closedHiHat.wav").toURI().toString());
    private AudioClip s11 = new AudioClip(new File("src\\midifckn\\soundFiles\\cymbalRide1.wav").toURI().toString());
    private AudioClip s12 = new AudioClip(new File("src\\midifckn\\soundFiles\\cymbalRide2.wav").toURI().toString());
    private AudioClip s13 = new AudioClip(new File("src\\midifckn\\soundFiles\\crash.wav").toURI().toString());
    private AudioClip s14 = new AudioClip(new File("src\\midifckn\\soundFiles\\crashDistorted.wav").toURI().toString());
    //4th Row Sound
    private AudioClip s15 = new AudioClip(new File("src\\midifckn\\soundFiles\\chordAM.wav").toURI().toString());
    private AudioClip s16 = new AudioClip(new File("src\\midifckn\\soundFiles\\chordF#M.wav").toURI().toString());
    private AudioClip s17 = new AudioClip(new File("src\\midifckn\\soundFiles\\guitarWowChord.wav").toURI().toString());
    private AudioClip s18 = new AudioClip(new File("src\\midifckn\\soundFiles\\cowbell.wav").toURI().toString());     
    private AudioClip s19 = new AudioClip(new File("src\\midifckn\\soundFiles\\clap2.wav").toURI().toString());
   //5th Row Sound
    private AudioClip s20 = new AudioClip(new File("src\\midifckn\\soundFiles\\808Blaster.wav").toURI().toString());
    private AudioClip s21 = new AudioClip(new File("src\\midifckn\\soundFiles\\808Blaster.wav").toURI().toString());     
    private AudioClip s22 = new AudioClip(new File("src\\midifckn\\soundFiles\\808Blaster.wav").toURI().toString());
    private AudioClip s23 = new AudioClip(new File("src\\midifckn\\soundFiles\\808Blaster.wav").toURI().toString());
    private AudioClip s24 = new AudioClip(new File("src\\midifckn\\soundFiles\\808Blaster.wav").toURI().toString());  
    //Tracks
    private AudioClip t0 = new AudioClip(new File("src\\midifckn\\soundFiles\\leadPopsLoops.wav").toURI().toString());
    private AudioClip t1 = new AudioClip(new File("src\\midifckn\\soundFiles\\majorPluckCmLoop.wav").toURI().toString());     
    private AudioClip t2 = new AudioClip(new File("src\\midifckn\\soundFiles\\trapLoop4.wav").toURI().toString());
    private AudioClip t3 = new AudioClip(new File("src\\midifckn\\soundFiles\\organLead.wav").toURI().toString());
    private AudioClip t4 = new AudioClip(new File("src\\midifckn\\soundFiles\\drop.wav").toURI().toString()); 
    
    
    private AudioClip[] sampleGrid = {
        s0, s1, s2, s3, s4,
        s5, s6, s7, s8, s9,
        s10, s11, s12, s13, s14,
        s15, s16, s17, s18, s19,
        s20, s21, s22, s23, s24
    };
    private AudioClip[] trackGrid = {t0, t1, t2, t3, t4};
    
    private double savedVolume = 0;
    
    public AudioClip getButtonSound(int choice){
        return sampleGrid[choice];
    }
    
    public AudioClip getTrackSound(int choice) {
        return trackGrid[choice];
    }
    
    public double changeVolume(int choice) {
        double h = sampleGrid[0].getVolume();
        if (choice == 1 && h < 1) {
            for (int i = 0; i < 25; i++) {
                sampleGrid[i].setVolume(h + 0.1);
            }
            for (int i = 0; i < 5; i++) {
                trackGrid[i].setVolume(h + 0.1);
            }
        }
        else if (choice == 0 && h > 0) {
            for (int i = 0; i < 25; i++) {
                sampleGrid[i].setVolume(h - 0.1);
            }
            for (int i = 0; i < 5; i++) {
                trackGrid[i].setVolume(h - 0.1);
            }
        }
        else if (choice == 2) {
            savedVolume = h;
            for (int i = 0; i < 25; i++) {
                sampleGrid[i].setVolume(0);
            }
            for (int i = 0; i < 5; i++) {
                trackGrid[i].setVolume(0);
            }
        }
        else if (choice == 3) {
            for (int i = 0; i < 25; i++) {
                sampleGrid[i].setVolume(savedVolume);
            }
            for (int i = 0; i < 5; i++) {
                trackGrid[i].setVolume(savedVolume);
            }
        }
        else if (choice == 4) {
            for (int i = 0; i < 25; i++) {
                sampleGrid[i].setVolume(-1000);
            }
            for (int i = 0; i < 5; i++) {
                trackGrid[i].setVolume(-1000);
            }
        }
        return sampleGrid[0].getVolume();
    }
    
    /*public String loadSound(int choice) {
        FileChooser file1 = new FileChooser();
        AudioClip s26 = new AudioClip(file1);
        sampleGrid[choice] = s26;
        return "New sound added to button";
    }*/
}