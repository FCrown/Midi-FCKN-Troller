/*
The MIDI FCKN-troller

Date: May 23, 2018
Designed by: Francisco Coronado, fcoronado1194@gmail.com 
        and  Khoa Nguyen, kaydeghet@gmail.com

This program is a digital MIDI Controller. It has the looks and feel of a launch pad.
It can be used to make music and record audio. 
Its really easy to learn to play, but pretty difficult to make a track because
the MIDI Controller relies heavily on the users timing and pattern.
The device come with standard sound files, and it could load in the users
choice for sound clips making it very versatile and customizable.
*/

package midifckn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
This class contains the main stage loaded up.
It uses both FXML and CSS for GUI design to make it look sweeter
*/
public class MIDIFCKN extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        

        Parent root = FXMLLoader.load(getClass().getResource("GUIBuild.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("GUIDesign.css").toExternalForm());
        
        stage.setScene(scene);
        stage.setTitle("MIDI FCKN-troller");
        stage.show();
    }

    /**
     * necessary to run the stage.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
