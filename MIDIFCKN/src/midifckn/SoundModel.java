package midifckn;

import java.io.File;
import javafx.scene.media.AudioClip;


public class SoundModel {
    
    //1st Row Sound
    private AudioClip s0 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\808Blaster.wav").toURI().toString());
    private AudioClip s1 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\808Kick2.wav").toURI().toString());
    private AudioClip s2 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\snareDry.wav").toURI().toString());
    private AudioClip s3 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\snareCrusher.wav").toURI().toString());
    private AudioClip s4 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\snareBamboo.wav").toURI().toString());
    //2nd Row Sound
    private AudioClip s5 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\808Kick.wav").toURI().toString());
    private AudioClip s6 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\808Kick4D#.wav").toURI().toString());
    private AudioClip s7 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\808KickE.wav").toURI().toString());
    private AudioClip s8 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\snareSoft.wav").toURI().toString());
    private AudioClip s9 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\snareLoud.wav").toURI().toString());
   //3rd Row Sound
    private AudioClip s10 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\closedHiHat.wav").toURI().toString());
    private AudioClip s11 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\cymbalRide1.wav").toURI().toString());
    private AudioClip s12 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\cymbalRide2.wav").toURI().toString());
    private AudioClip s13 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\crash.wav").toURI().toString());
    private AudioClip s14 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\crashDistorted.wav").toURI().toString());
    //4th Row Sound
    private AudioClip s15 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\chordAM.wav").toURI().toString());
    private AudioClip s16 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\chordF#M.wav").toURI().toString());
    private AudioClip s17 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\guitarWowChord.wav").toURI().toString());
    private AudioClip s18 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\cowbell.wav").toURI().toString());     
    private AudioClip s19 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\clap2.wav").toURI().toString());
   //5th Row Sound
    private AudioClip s20 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\leadPopsLoops.wav").toURI().toString());
    private AudioClip s21 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\majorPluckCmLoop.wav").toURI().toString());     
    private AudioClip s22 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\trapLoop4.wav").toURI().toString());
    private AudioClip s23 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\organLead.wav").toURI().toString());
    private AudioClip s24 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\drop.wav").toURI().toString());  
    //Tracks
    private AudioClip t0 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\leadPopsLoops.wav").toURI().toString());
    private AudioClip t1 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\majorPluckCmLoop.wav").toURI().toString());     
    private AudioClip t2 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\trapLoop4.wav").toURI().toString());
    private AudioClip t3 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\organLead.wav").toURI().toString());
    private AudioClip t4 = new AudioClip(new File("C:\\Users\\Kay\\Desktop\\MIDIFCKN\\src\\midifckn\\soundFiles\\drop.wav").toURI().toString()); 
    
    
    private AudioClip[] sampleGrid = {
        s0, s1, s2, s3, s4,
        s5, s6, s7, s8, s9,
        s10, s11, s12, s13, s14,
        s15, s16, s17, s18, s19,
        s20, s21, s22, s23, s24
    };
    private AudioClip[] trackGrid = {t0, t1, t2, t3, t4};
    
    public AudioClip getButtonSound(int choice){
        return sampleGrid[choice];
    }
    
    public AudioClip getTrackSound(int choice) {
        return trackGrid[choice];
        
    }
    
}