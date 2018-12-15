package model;

import commands.CommandInitializer;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.view_component.TabWorkspace;

import java.io.File;
import java.util.ResourceBundle;

/**
 * The main class.
 * @author duytrieu
 */
public class Main extends Application{


    /**
     * This method is run to start the whole GUI and game
     * @param stage Stage
     */
    @Override
    public void start (Stage stage) {
        TabWorkspace twsp = new TabWorkspace();
        stage.setTitle("SLogo Team 08");
        stage.setScene(twsp.getMyScene());
        stage.show();
    }


    public static void main (String[] args) {
        launch(args);
    }


}
