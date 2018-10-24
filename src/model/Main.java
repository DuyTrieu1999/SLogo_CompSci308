package model;

import commands.CommandNode;
import commands.Forward;
import javafx.application.Application;
import javafx.scene.paint.Color;
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
        Turtle t = new Turtle(0, 0, Color.WHITE);
        CommandParser test = new CommandParser( "ifelse fd 20 [ fd 50 ] [ bk 50 ]", t);
        System.out.println(test.getOutput());
    }

    public static void main (String[] args) {
        launch(args);
    }

}
