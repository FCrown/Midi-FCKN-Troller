package midifckn;

import java.io.File;
import javafx.scene.media.AudioClip;

/*
This class is used to
*/
public class SoundModel {
    
    /////////////////////////////////////FIELD/////////////////////////////////////
    //1st Row Sound
    private AudioClip s0 = new AudioClip(new File("src/midifckn/soundFiles/808Blaster.wav").toURI().toString());
    private AudioClip s1 = new AudioClip(new File("src/midifckn/soundFiles/bongo.wav").toURI().toString());
    private AudioClip s2 = new AudioClip(new File("src/midifckn/soundFiles/snareDry.wav").toURI().toString());
    private AudioClip s3 = new AudioClip(new File("src/midifckn/soundFiles/snareCrusher.wav").toURI().toString());
    private AudioClip s4 = new AudioClip(new File("src/midifckn/soundFiles/snareBamboo.wav").toURI().toString());
    //2nd Row Sound
    private AudioClip s5 = new AudioClip(new File("src/midifckn/soundFiles/808Kick.wav").toURI().toString());
    private AudioClip s6 = new AudioClip(new File("src/midifckn/soundFiles/808Kick4D#.wav").toURI().toString());
    private AudioClip s7 = new AudioClip(new File("src/midifckn/soundFiles/808KickE.wav").toURI().toString());
    private AudioClip s8 = new AudioClip(new File("src/midifckn/soundFiles/snareSoft.wav").toURI().toString());
    private AudioClip s9 = new AudioClip(new File("src/midifckn/soundFiles/snareLoud.wav").toURI().toString());
   //3rd Row Sound
    private AudioClip s10 = new AudioClip(new File("src/midifckn/soundFiles/closedHiHat.wav").toURI().toString());
    private AudioClip s11 = new AudioClip(new File("src/midifckn/soundFiles/cymbalRide1.wav").toURI().toString());
    private AudioClip s12 = new AudioClip(new File("src/midifckn/soundFiles/cymbalRide2.wav").toURI().toString());
    private AudioClip s13 = new AudioClip(new File("src/midifckn/soundFiles/crash.wav").toURI().toString());
    private AudioClip s14 = new AudioClip(new File("src/midifckn/soundFiles/crashDistorted.wav").toURI().toString());
    //4th Row Sound
    private AudioClip s15 = new AudioClip(new File("src/midifckn/soundFiles/chordAM.wav").toURI().toString());
    private AudioClip s16 = new AudioClip(new File("src/midifckn/soundFiles/chordF#M.wav").toURI().toString());
    private AudioClip s17 = new AudioClip(new File("src/midifckn/soundFiles/guitarWowChord.wav").toURI().toString());
    private AudioClip s18 = new AudioClip(new File("src/midifckn/soundFiles/cowbell.wav").toURI().toString());     
    private AudioClip s19 = new AudioClip(new File("src/midifckn/soundFiles/clap2.wav").toURI().toString());
   //5th Row Sound
    private AudioClip s20 = new AudioClip(new File("src/midifckn/soundFiles/TrumpetHarmonies.wav").toURI().toString());
    private AudioClip s21 = new AudioClip(new File("src/midifckn/soundFiles/sax.wav").toURI().toString());     
    private AudioClip s22 = new AudioClip(new File("src/midifckn/soundFiles/shaker.wav").toURI().toString());
    private AudioClip s23 = new AudioClip(new File("src/midifckn/soundFiles/classicImpact.wav").toURI().toString());
    private AudioClip s24 = new AudioClip(new File("src/midifckn/soundFiles/KSHMRVocal.wav").toURI().toString());  
    //Tracks
    private AudioClip t0 = new AudioClip(new File("src/midifckn/soundFiles/leadPopsLoops.wav").toURI().toString());
    private AudioClip t1 = new AudioClip(new File("src/midifckn/soundFiles/shakerLoop.wav").toURI().toString());     
    private AudioClip t2 = new AudioClip(new File("src/midifckn/soundFiles/trapLoop4.wav").toURI().toString());
    private AudioClip t3 = new AudioClip(new File("src/midifckn/soundFiles/organLead.wav").toURI().toString());
    private AudioClip t4 = new AudioClip(new File("src/midifckn/soundFiles/drop.wav").toURI().toString());
    
    
    private AudioClip[] sampleGrid = {
        s0, s1, s2, s3, s4,
        s5, s6, s7, s8, s9,
        s10, s11, s12, s13, s14,
        s15, s16, s17, s18, s19,
        s20, s21, s22, s23, s24
    };
    private AudioClip[] trackGrid = {t0, t1, t2, t3, t4};
    
    private double savedVolume = 0;
    
    
    
    ////////////////////////////////////METHODS//////////////////////////////////////////
    public AudioClip getButtonSound(int choice){
        return sampleGrid[choice];
    }
    
    public AudioClip getTrackSound(int choice) {
        return trackGrid[choice];
    }
    
    /*
    This method is called on in the action events for the controller
    UP = 0, DOWN = 1, Mute = 2, Unmute = 3, Recordx50 = 4
    When 0 is called, it loops through both sample and track array, and increase all volume
    When 1 is called, it decreases all volume of all AudioClips
    When 2 is called, it sets all AudioClip volume to zero, and stores the previous volume in a variable
    When 3 is called, it sets all AudioClip back to the previous volume stored in variable
    When 4 is called, it sets all AudioClip volume to -10000 as a joke for clicking record button too much
    */
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
    
    
    /*
    This method is used for replacing the sound within one of the sound buttons
    
    It uses a try catch for exception handling. All the strings from the sample sounds should be able to convert to integers
    If it cannot be converted to an integer, it will have a number format exception, and it will be a Track button.
    If the user loads in another file thats not an audio file, the exception handling catch will notify the user in the result label
    If no buttons were selected, it will also notify the user
    */
    public String loadSound(String choice, String pathChoice) {
        int a;
        try { //If the combobox choice was 0-24
            a = Integer.parseInt(choice);
            AudioClip ac = new AudioClip(new File(pathChoice).toURI().toString());
            sampleGrid[a] = ac;
            return "New sound added to button" + a;
        }
        catch (NumberFormatException nfe) { //If the string cant be converted to integer, choice was T1-T5
            if (choice == "T1")
                a = 0;
            else if (choice == "T2")
                a = 1;
            else if (choice == "T3")
                a = 2;
            else if (choice == "T4")
                a = 3;
            else if (choice == "T5")
                a = 4;
            else //If no combobox selection was made
                return "Please select a button to replace";
            AudioClip ac = new AudioClip(new File(pathChoice).toURI().toString());
            trackGrid[a] = ac;
            return "New sound added to track" + (a+1);
        }
        catch (Exception e) { //If the file extension wanted audio file
            return "Please select a proper Audio file";
        }
    }
}