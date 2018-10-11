package model;

import javafx.application.Application;
import javafx.stage.Stage;
import view.MainUI;

/**
 *
 * @author duytrieu
 */
public class Main extends Application{
    @Override
    public void start (Stage stage) {
        MainUI ui = new MainUI();
        stage.setTitle("SLogo");
        stage.setScene(ui.sceneInit());
        stage.show();
    }

    public static void main (String[] args) {
        launch(args);
    }
}