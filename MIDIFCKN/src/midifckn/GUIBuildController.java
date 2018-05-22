package midifckn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import static javafx.scene.media.AudioClip.INDEFINITE;


public class GUIBuildController implements Initializable {
    
    @FXML private Label resultLabel;
    @FXML private Label volumeLabel;
    @FXML private Label muteLabel;
    @FXML private Label statusLabel;
    private int recordCount = 0;
    private int num1;
    private boolean resultUpdate = true;
    private boolean statusUpdate = false;
    private boolean muteUpdate = false;
    private SoundModel SM1 = new SoundModel();
    private String trackMessage = "";
    private final boolean[] trackOnOff = {false, false, false, false, false};
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML private void handleButtonText(ActionEvent event) {
        resultLabel.setText("THIS WILL BE AN ACTION EVENT HANDLER");
    }
    
    @FXML public void processVolume(ActionEvent event) {
        if (!muteUpdate) {
            resultLabel.setText("Volume changed");
            String volumeText = ((Button)event.getSource()).getAccessibleText();
            num1 = Integer.parseInt(volumeText);
            double v = (int) (SM1.changeVolume(num1) * 10);
            volumeLabel.setText("Vol: " + v);
        }
        else
            resultLabel.setText("Can't change volume. Mute button still on!");
    }
    
    @FXML public void powerOff(ActionEvent event) {
        resultLabel.setText("Are you sure you want to exit?");
        System.exit(0);
    }
    
    @FXML public void processMute(ActionEvent event) {
        resultLabel.setText("");
        if (muteUpdate) {
            double v = (int) (SM1.changeVolume(3) * 10);
            muteLabel.setText("");
            volumeLabel.setText("Vol: " + v);
            muteUpdate = false;
        }
        else {
            double v = SM1.changeVolume(2);
            muteLabel.setText("MUTED");
            volumeLabel.setText("Vol: 0");
            muteUpdate = true;
        }
    }
    @FXML public void processLoad(ActionEvent event) {
        resultLabel.setText("Please Select a color button to overwrite");
        
    }
    
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
            double v = SM1.changeVolume(4);
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
    
    @FXML public void processSampleButtons(ActionEvent event) {
        String value = ((Button)event.getSource()).getAccessibleText();
        resultLabel.setText("Button: " + value);
        num1 = Integer.parseInt(value);
        AudioClip output = SM1.getButtonSound(num1);
        output.stop();
        output.play();
    }
    
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
        trackMessage = "Looping:";
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (trackOnOff[i])
                trackMessage += (" T" + (i+1));
            else
                count++;
        }
        if (count == 5)
            trackMessage = "No Loops";
        statusLabel.setText(trackMessage);
    }
    
}
