
package midifckn;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public final class SoundChooserGUI extends Application {
 
    private Desktop desktop = Desktop.getDesktop();
 
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Select a sound file");
 
        FileChooser fileChooser = new FileChooser();
 
        Button openButton = new Button("Open a Picture...");
        ComboBox buttonComboBox = new ComboBox();
        buttonComboBox.getItems().addAll(
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "T1",
            "T2",
            "T3",
            "T4",
            "T5");
        
        openButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                        openFile(file);
                    }
                }
            });
 

 
 
        final GridPane inputGridPane = new GridPane();
 
        GridPane.setConstraints(openButton, 0, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton);
 
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        stage.setScene(new Scene(rootGroup));
        stage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                SoundChooserGUI.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
}