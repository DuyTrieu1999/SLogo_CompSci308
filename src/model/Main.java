package model;

import commands.CommandInitializer;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.view_component.TabWorkspace;

import java.io.File;
import java.util.ResourceBundle;

/**
 *
 * @author duytrieu
 */
public class Main extends Application{


    @Override
    public void start (Stage stage) {
        TabWorkspace twsp = new TabWorkspace();
        stage.setTitle("SLogo Team 08");
        stage.setScene(twsp.getMyScene());
        stage.show();
    }
    /*

    @Override
    public void start(Stage stage){
        Turtle t = new Turtle(0, 0, Color.WHITE);
        VariableMap variableMap = new VariableMap();
        CommandInitializer commandInitializer = new CommandInitializer(ResourceBundle.getBundle("languages/English"));
        CommandParser parser = new CommandParser(variableMap, commandInitializer, t);
        parser.parse("make poop 50 make lol 40\nto poopy [ :hi ] [ fd hi bk 50 ]");
        parser.getOutput();
        Saver s = new Saver(variableMap, commandInitializer, new File("lol.txt"));
        s.save();

    }
    */



//    @Override
//    public void start(Stage stage){
//        Turtle t = new Turtle(0, 0, Color.WHITE);
//        CommandInitializer c = new CommandInitializer(ResourceBundle.getBundle("languages/English"));
//        VariableMap v = new VariableMap();
//        CommandParser test = new CommandParser(v, c, t);
//        test.parse("to butt [ :x ] [ forward :x forward 20 ]\nbutt 50");
//        System.out.println(test.getMyTurtle().getLines());
//
//    }


    public static void main (String[] args) {
        launch(args);
    }


}
