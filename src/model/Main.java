package model;

import commands.CommandNode;
import commands.Forward;
import javafx.application.Application;
import javafx.stage.Stage;
import view.SLogoView;

/**
 *
 * @author duytrieu
 */
public class Main extends Application{

    /*
    @Override
    public void start (Stage stage) {
        SLogoView ui = new SLogoView();
        stage.setTitle("SLogo");
        stage.setScene(ui.sceneInit());
        stage.show();
    }
    */

    @Override
    public void start(Stage stage){
        CommandParser test = new CommandParser("fd sum sum sum 10 fd 30 20 30 fd 40");
    }

    public static void main (String[] args) {
        launch(args);
    }
}
