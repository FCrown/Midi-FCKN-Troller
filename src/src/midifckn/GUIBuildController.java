package midifckn;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;


public class GUIBuildController implements Initializable {
    
    @FXML private Label resultLabel;
    @FXML private Label volumeLabel;
    @FXML private Label muteLabel;
    @FXML private Label statusLabel;
    private int choice;
    private int num1;
    private boolean resultUpdate = true;
    private boolean statusUpdate = false;
    private boolean muteUpdate = false;
    private SoundModel SM1 = new SoundModel();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML private void handleButtonText(ActionEvent event) {
        resultLabel.setText("THIS WILL BE AN ACTION EVENT HANDLER");
    }
    
    @FXML public void volumeControl(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML public void powerOff(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML public void processMute(ActionEvent event) {
        if (muteUpdate) {
            muteLabel.setText("");
            //We need to change volume into an integer using setVolume()
            volumeLabel.setText("Volume: 5");
            muteUpdate = false;
        }
            else {
            muteLabel.setText("MUTED");
            volumeLabel.setText("Volume: 0");
            muteUpdate = true;
        }
    }
    
    @FXML public void processRecord(ActionEvent event) {
        if (statusUpdate) {
            statusLabel.setText("");
            statusUpdate = false;
        }
            else {
            statusLabel.setText("RECORDING");
            statusUpdate = true;
        }
    }
    
    @FXML public void processSampleButtons(ActionEvent event) {
        if (resultUpdate) {
            resultLabel.setText("");
            resultUpdate = false;
        }
        String value = ((Button)event.getSource()).getAccessibleText();
        resultLabel.setText(value);
        num1 = Integer.parseInt(value);
        AudioClip output = SM1.getButtonSound(num1);
        output.play();
        resultUpdate = true;
    }
    
    @FXML public void processTrackButtons(ActionEvent event) {
        if (resultUpdate) {
            resultLabel.setText("");
            resultUpdate = false;
        }
        String value = ((Button)event.getSource()).getAccessibleText();
        resultLabel.setText(value);
        num1 = Integer.parseInt(value);
        AudioClip output = SM1.getTrackSound(num1);
        output.play();
        resultUpdate = true;
    }
    
}
