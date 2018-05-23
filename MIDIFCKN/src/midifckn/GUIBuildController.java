package midifckn;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import static javafx.scene.media.AudioClip.INDEFINITE;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/*
    This is a controller class for the GUIBuild FXML file.
    This class holds all the actions whenever an event happens on the GUI.
    The actions are broken down into process Buttons for easy reading.
*/
public class GUIBuildController implements Initializable {
    
    // The labels are used to update and add text on the GUI. The status label shows looping updates
    @FXML private Label resultLabel;
    @FXML private Label volumeLabel;
    @FXML private Label muteLabel;
    @FXML private Label statusLabel;
    private int recordCount = 0; //playful message button, keeps count of record button presses
    private int num1;
    private boolean muteUpdate = false;
    private final SoundModel SM1 = new SoundModel();
    private String trackMessage;
    private String buttonChoice;
    private String soundPath;
    private final boolean[] trackOnOff = {false, false, false, false, false};    //This boolean array keeps me update on all looping tracks
    private File file;

    //runs first, necessary just like a main class
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    
    /*
    This is an action event for when the volume buttons are pressed.
    If it is muted, the else statement will run.
    The Accessible text are stored as 0 for UP, 1 for Down.
    The method changedVolume is called to increase or decrease the volume.
    The volume double is multiplied by 10 and casted as int for better display.
    */
    @FXML public void processVolume(ActionEvent event) {
        if (!muteUpdate) {
            resultLabel.setText("Volume changed");
            String volumeText = ((Button)event.getSource()).getAccessibleText();
            num1 = Integer.parseInt(volumeText);
            int v = (int) (SM1.changeVolume(num1) * 10);
            volumeLabel.setText("Vol: " + v);
        }
        else
            resultLabel.setText("Can't change volume. Mute button still on!");
    }
    
    
    /*
    This is an action event for when the power buttons is pressed.
    STILL NEED TO ADD IN A KEY LISTENER FOR Y/N TO EXIT.
    System.exit(0) is used to exit javafx stages.
    */
    @FXML public void powerOff(ActionEvent event) {
        resultLabel.setText("Are you sure you want to exit?");
        System.exit(0);
    }
    
    /*
    This is an action event for when the mute buttons is pressed.
    If not muted, it will store the volume in a temporary variable,
    Then it will mute all the sounds, and display it.
    If it was already muted, it will recall the previous volume and unmute
    it back to that previous volume. 
    */
    @FXML public void processMute(ActionEvent event) {
        resultLabel.setText("");
        if (muteUpdate) {
            int v = (int) (SM1.changeVolume(3) * 10);
            muteLabel.setText("");
            volumeLabel.setText("Vol: " + v);
            muteUpdate = false;
        }
        else {
            double v = SM1.changeVolume(2);
            muteLabel.setText("MUTED");
            volumeLabel.setText(" ");
            muteUpdate = true;
        }
    }
    
    /*
    This is an action event for when the load buttons is pressed.
    This is the most intricate button in the program.
    It will open a new stage with three components.
    The top part is a button that loads a filechooser and displays the path on the label.
    The next part is a label that displays to choose a button, with a combobox to show all the choices.
    The last part is a replace button. Upon pressing replace, it will run a sound model method.
    The method will check to see if the file is an audio file, and if a combobox selection is made.
    
    theres a try catch, if the stage cannot be loaded, it will display in the result label.
    */
    @FXML public void processLoad(ActionEvent event) {
        resultLabel.setText("Please select a sound file and button to replace");
        try {
            
            //Creating all the objects needed to make the popup GUI
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            VBox vbmain = new VBox();
            HBox hb = new HBox();
            VBox vb = new VBox();
            Button openButton = new Button("Open Sound...");
            Button replaceButton = new Button("Replace Sound");
            ComboBox buttonComboBox = new ComboBox();
            Label lb1 = new Label("Sound Path");
            Label lb2 = new Label("Button to replace");
            

            stage.setTitle("Select a sound file"); //sets title for stage
            lb1.setMaxWidth(400); //makes sure the label wont change the popup size
            lb1.setMinWidth(400);
            lb1.setStyle("-fx-background-color: #D9D9D9"); //makes the label visible
            buttonComboBox.getItems().addAll("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
                                                 "16","17","18","19","20","21","22","23","24","T1","T2","T3","T4","T5");
           
            //When the Open Sound button is pressed, it opens up a file chooser
            openButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    file = fileChooser.showOpenDialog(stage);
                    if (file != null)
                        lb1.setText(file.toString()); //Store the file into a string to load into a button later
                }
            });
            

            vb.setSpacing(2);
            vb.getChildren().addAll(openButton, lb1);
            hb.setSpacing(2);
            hb.setPadding(new Insets(20,20,20,20));
            hb.setSpacing(10);
            hb.getChildren().addAll(lb2,buttonComboBox, replaceButton);
            
            vbmain.setSpacing(30);
            vbmain.setAlignment(Pos.BASELINE_RIGHT);
            vbmain.getChildren().addAll(vb, hb);
            vbmain.setStyle("-fx-background-color: #999999");
            Pane root2 = new Pane();
            root2.getChildren().addAll(vbmain);
            
            stage.setScene(new Scene(root2)); //adds all the objects to the stage
            stage.show();
            
            
            //The replace button loads the combobox choice and the audio path to a string
            //Then it calls a soundmodel method that replaces the sound to the selected button
            replaceButton.setOnAction(e -> {
                buttonChoice = (String) buttonComboBox.getSelectionModel().getSelectedItem();
                soundPath = lb1.getText();
                
                String s = SM1.loadSound(buttonChoice, soundPath);
                resultLabel.setText(s);
            });
        }
        
        //Incase the popup stage couldn't be loaded
        catch (Exception e) {
            resultLabel.setText("Sound loader did not open properly"); 
        }
    }
    
    
    /*
    This is an action event for when the record buttons is pressed.
    WE DIDNT HAVE ENOUGH TIME TO FINISH THIS PART
    Instead a little quirky text keeps changing if this button is pressed repeatedly
    */
    @FXML public void processRecord(ActionEvent event) {
        recordCount++;
        if (recordCount==1)
            resultLabel.setText("Record button is broken. Dont click this again");
        else if (recordCount==2)
            resultLabel.setText("Stop it.");
        else if (recordCount==3)
            resultLabel.setText("STOP IT");
        else if (recordCount==4)
            resultLabel.setText("I'm warning you");
        else if (recordCount==5)
            resultLabel.setText("I said stop it");
        else if (recordCount==6)
            resultLabel.setText("I'm going to count to three");
        else if (recordCount==7)
            resultLabel.setText("If you dont stop");
        else if (recordCount==8)
            resultLabel.setText("You dont want to know what will happen");
        else if (recordCount==9)
            resultLabel.setText("One...");
        else if (recordCount==10)
            resultLabel.setText("You better listen");
        else if (recordCount==11)
            resultLabel.setText("Two....");
        else if (recordCount==12)
            resultLabel.setText("People must hate you");
        else if (recordCount==13)
            resultLabel.setText("Three...");
        else if (recordCount==14)
            resultLabel.setText("I warned you!");
        else if (recordCount==15) {
            resultLabel.setText("CRASH, PERMANENT MUTE");
            double v = SM1.changeVolume();
            volumeLabel.setText("Vol: -INFINITY");
        }
        else if (recordCount==16)
            resultLabel.setText("Look what you did");
        else if (recordCount==17)
            resultLabel.setText("We had a good program");
        else if (recordCount==18)
            resultLabel.setText("And you broke it");
        else if (recordCount==19)
            resultLabel.setText("Thats why no one buys you anything");
        else if (recordCount==20)
            resultLabel.setText("Because you never listen");
        else if (recordCount==21)
            resultLabel.setText("What if I told you nothing else will happen");
        else if (recordCount==22)
            resultLabel.setText("If you click me");
        else if (recordCount<=30)
            resultLabel.setText("");
        else if (recordCount<=33)
            resultLabel.setText("Of course you'd still be clicking");
        else if (recordCount==34)
            resultLabel.setText("You already broke the FCKN-troller!");
        else if (recordCount==35)
            resultLabel.setText("Why are you still poking at it");
        else if (recordCount<=58 && recordCount%2==0)
            resultLabel.setText("Go away");
        else if (recordCount<=58)
            resultLabel.setText("");
        else if (recordCount<=61)
            resultLabel.setText("Whoa, you are PER-SIS-TENT");
        else if (recordCount<=63)
            resultLabel.setText("Fine, I'll let you in on a little secret");
        else if (recordCount<=65)
            resultLabel.setText("But I'll only tell you if you click me");
        else if (recordCount<=113)
            resultLabel.setText("" + (119-recordCount) + " more times");
        else if (recordCount==118)
            resultLabel.setText("1 More!!!!");
        else if (recordCount==119)
            resultLabel.setText("YOU DIID IT");
        else if (recordCount==116)
            resultLabel.setText("CONGRATULATIONS");
        else if (recordCount==117)
            resultLabel.setText("YOURE THE BEST BUTTON PUSHER IN THE WORLD");
        else if (recordCount==118)
            resultLabel.setText("Your prize is.. ... ....");
        else
            resultLabel.setText("VOID: ERROR, PLEASE RESTART DEVICE");
    }
    
    
    /*
    This is an action event for when the sound buttons are pressed.
    All the sound buttons have accessibletext 0-24
    This is important because the text is parsed as an int
    and called using a AudioClip array made in soundmodel.java
    */
    @FXML public void processSampleButtons(ActionEvent event) {
        String value = ((Button)event.getSource()).getAccessibleText();
        resultLabel.setText("Playing Sound #" + value);
        num1 = Integer.parseInt(value);
        AudioClip output = SM1.getButtonSound(num1);
        output.stop();
        output.play();
    }
    
    
    /*
    This is an action event for when the track buttons are pressed.
    Track buttons are exactly identical to the sound buttons.
    The only difference is that they loop infinately unless clicked again
    */
    @FXML public void processTrackButtons(ActionEvent event) {
        String value = ((Button)event.getSource()).getAccessibleText();
        num1 = Integer.parseInt(value);
        AudioClip output = SM1.getTrackSound(num1);
        if (!trackOnOff[num1]) {
            resultLabel.setText("T" + (num1+1) + " started looping");
            output.setCycleCount(INDEFINITE);
            output.play();
            trackOnOff[num1] = true;
        }
        else {
            resultLabel.setText("T" + (num1+1) + " stopped looping");
            output.stop();
            trackOnOff[num1] = false;
        }
        
        //This for loop runs through the boolean array to determine if theres any track looping
        trackMessage = "Looping:";
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (trackOnOff[i])
                trackMessage += (" T" + (i+1));
            else
                count++; 
        }
        if (count == 5) //When the count is 5, all the booleans are false
            trackMessage = " ";
        statusLabel.setText(trackMessage);
    }
}
