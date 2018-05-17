import javafx.geometry.Insets; 
import javafx.application.Application;

import javafx.scene.control.Button;
import javafx.stage.Stage;

  
import java.io.File;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;

/**
 * 
 * This code is meant to display an early working prototype midi controller on screen
 * Will implement FXML code in next update 
 *
 */
public class Tester extends Application{
    Stage window;
    Scene scene1;
   
   //Buttons for the sounds
   //First Row 
   Button s1Button;
   Button s2Button;
   Button s3Button;
   Button s4Button;
   Button s5Button;
   
   //Second Row
   Button s6Button;
   Button s7Button;
   Button s8Button;
   Button s9Button;
   Button s10Button;
   
   //3rd Row
   Button s11Button;
   Button s12Button;
   Button s13Button;
   Button s14Button;
   Button s15Button;
   
   //4th Row
   Button s16Button;
   Button s17Button;
   Button s18Button;
   Button s19Button;
   Button s20Button;
   
   //5th Row
   Button s21Button;
   Button s22Button;
   Button s23Button;
   Button s24Button;
   Button s25Button;
   
   //Sounds
   //1st Row
   AudioClip s1 = new AudioClip(new File("soundFiles/808Blaster.wav").toURI().toString());
   AudioClip s2 = new AudioClip(new File("soundFiles/808Kick.wav").toURI().toString());
   AudioClip s3 = new AudioClip(new File("soundFiles/808Kick2.wav").toURI().toString());
   AudioClip s4 = new AudioClip(new File("soundFiles/808Kick4D#.wav").toURI().toString());
   AudioClip s5 = new AudioClip(new File("soundFiles/808KickE.wav").toURI().toString());
   
   //2nd Row
   AudioClip s6 = new AudioClip(new File("soundFiles/snareSoft.wav").toURI().toString());
   AudioClip s7 = new AudioClip(new File("soundFiles/snareLoud.wav").toURI().toString());
   AudioClip s8 = new AudioClip(new File("soundFiles/snareDry.wav").toURI().toString());
   AudioClip s9 = new AudioClip(new File("soundFiles/snareCrusher.wav").toURI().toString());
   AudioClip s10 = new AudioClip(new File("soundFiles/snareBamboo.wav").toURI().toString());
   
   //3rd Row
   AudioClip s11 = new AudioClip(new File("soundFiles/closedHiHat.wav").toURI().toString());
   AudioClip s12 = new AudioClip(new File("soundFiles/cymbalRide1.wav").toURI().toString());
   AudioClip s13 = new AudioClip(new File("soundFiles/cymbalRide2.wav").toURI().toString());
   AudioClip s14 = new AudioClip(new File("soundFiles/crash.wav").toURI().toString());
   AudioClip s15 = new AudioClip(new File("soundFiles/crashDistorted.wav").toURI().toString());
    
   AudioClip s16 = new AudioClip(new File("soundFiles/chordAM.wav").toURI().toString());
   AudioClip s17 = new AudioClip(new File("soundFiles/chordF#M.wav").toURI().toString());
   AudioClip s18 = new AudioClip(new File("soundFiles/guitarWowChord.wav").toURI().toString());
   AudioClip s19 = new AudioClip(new File("soundFiles/cowbell.wav").toURI().toString());     
   AudioClip s20 = new AudioClip(new File("soundFiles/clap2.wav").toURI().toString());
    
   //5th Row
   AudioClip s21 = new AudioClip(new File("soundFiles/leadPopsLoops.wav").toURI().toString());
   AudioClip s22 = new AudioClip(new File("soundFiles/majorPluckCmLoop.wav").toURI().toString());     
   AudioClip s23 = new AudioClip(new File("soundFiles/trapLoop4.wav").toURI().toString());
   AudioClip s24 = new AudioClip(new File("soundFiles/organLead.wav").toURI().toString());
   AudioClip s25 = new AudioClip(new File("soundFiles/drop.wav").toURI().toString()); 
    
   
    
   Button[] buttonGrid =  {s1Button, s2Button, s3Button, s4Button, s5Button,
                            s6Button, s7Button, s8Button, s9Button, s10Button,
                            s11Button, s12Button, s13Button, s14Button, s15Button, 
                            s16Button, s17Button, s18Button, s19Button, s20Button,
                            s21Button, s22Button, s23Button, s24Button, s25Button
                            };
    
   AudioClip[] sampleGrid = {s1, s2, s3, s4, s5,
                              s6, s7, s8, s9,s10, 
                              s11, s12, s13, s14, s15,
                              s16, s17, s18, s19, s20, 
                              s21, s22, s23, s24, s25
                             };
    
   
    
    
    
    public static void main(String[] args){
        launch(args);
    }
    

    

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        window.setTitle("Midi FCKN-Troller");
        
        GridPane padGrid = new GridPane();
        padGrid.setPadding(new Insets(20, 20, 20, 20));
        padGrid.setVgap(5);
        padGrid.setHgap(5);
        
        
        //loop that creates the new buttons and sets them on the buttonGrid
        for(int i = 0; i<25; i++){
            String si = "s" + i;
            buttonGrid[i] = new Button();
            
            if(i < 5)
                padGrid.setConstraints(buttonGrid[i], i, 0);
            else if(i>=5 && i <10)
                padGrid.setConstraints(buttonGrid[i], i-5, 1);
            else if(i>=10 && i <15)
                padGrid.setConstraints(buttonGrid[i], i-10, 2);
            else if(i>=15 && i <20)
                padGrid.setConstraints(buttonGrid[i], i-15, 3);
            else
                padGrid.setConstraints(buttonGrid[i], i-20, 4);

            
            padGrid.getChildren().add(buttonGrid[i]);
        }
        
     
        
       
        // Event handling.. e represents the event.. lambda expressions
        buttonGrid[0].setOnAction(e -> sampleGrid[0].play());
        buttonGrid[1].setOnAction(e -> sampleGrid[1].play());
        buttonGrid[2].setOnAction(e -> sampleGrid[2].play());
        buttonGrid[3].setOnAction(e -> sampleGrid[3].play());
        buttonGrid[4].setOnAction(e -> sampleGrid[4].play());
        
        buttonGrid[5].setOnAction(e -> sampleGrid[5].play());
        buttonGrid[6].setOnAction(e -> sampleGrid[6].play());
        buttonGrid[7].setOnAction(e -> sampleGrid[7].play());
        buttonGrid[8].setOnAction(e -> sampleGrid[8].play());
        buttonGrid[9].setOnAction(e -> sampleGrid[9].play());
        
        buttonGrid[10].setOnAction(e -> sampleGrid[10].play());
        buttonGrid[11].setOnAction(e -> sampleGrid[11].play());
        buttonGrid[12].setOnAction(e -> sampleGrid[12].play());
        buttonGrid[13].setOnAction(e -> sampleGrid[13].play());
        buttonGrid[14].setOnAction(e -> sampleGrid[14].play());
        
        buttonGrid[15].setOnAction(e -> sampleGrid[15].play());
        buttonGrid[16].setOnAction(e -> sampleGrid[16].play());
        buttonGrid[17].setOnAction(e -> sampleGrid[17].play());
        buttonGrid[18].setOnAction(e -> sampleGrid[18].play());
        buttonGrid[19].setOnAction(e -> sampleGrid[19].play());
        
        buttonGrid[20].setOnAction(e -> sampleGrid[20].play());
        buttonGrid[21].setOnAction(e -> sampleGrid[21].play());
        buttonGrid[22].setOnAction(e -> sampleGrid[22].play());
        buttonGrid[23].setOnAction(e -> sampleGrid[23].play());
        buttonGrid[24].setOnAction(e -> sampleGrid[24].play());


        
        
        
        
        Scene scene = new Scene(padGrid, 300, 500);
        
        String css = this.getClass().getResource("GuiDesigner.css").toExternalForm();
        
        scene.getStylesheets().add(css);

        window.setScene(scene);

        window.show();
    }
    
}
    

