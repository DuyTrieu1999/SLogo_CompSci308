package model;

import commands.CommandInitializer;
import commands.CommandNode;
import commands.Forward;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.SLogoView;

import java.util.ResourceBundle;

/**
 *
 * @author duytrieu
 */
public class Main extends Application{


    @Override
    public void start (Stage stage) {
        SLogoView ui = new SLogoView();
        stage.setTitle("SLogo");
        stage.setScene(ui.sceneInit());
        stage.show();
    }


    /*
    @Override
    public void start(Stage stage){
        Turtle t = new Turtle(0, 0, Color.WHITE);
        CommandInitializer c = new CommandInitializer(ResourceBundle.getBundle("languages/English"));
        VariableMap v = new VariableMap();
        CommandParser test = new CommandParser(v, c, t);
        test.parse("to butt [ :x ] [ forward :x forward 20 ]\nbutt 50");
        System.out.println(test.getOutput());
    }
    */

    public static void main (String[] args) {
        launch(args);
    }

}
