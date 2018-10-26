package model;

import commands.CommandInitializer;
import commands.CommandNode;
import commands.Forward;
import controller.Controller;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.SLogoView;
import view.view_component.TabWorkspace;

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



//    @Override
//    public void start(Stage stage){
//        Turtle t = new Turtle(0, 0, Color.WHITE);
//        //TabWorkspace tbws = new TabWorkspace();
//        Controller controller = new Controller();
//        System.out.println(controller.setTurtleSupplier());
//    }

    public static void main (String[] args) {
        launch(args);
    }


}
