package view.view_component;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.web.WebView;
import java.net.URL;

/**
 * PopupWindow
 *
 * creates a pop-up window to display more information to user
 *
 * @author brookekeene
 */
public class PopupWindow {
    private String myTitle;
    private String myContent;

    public PopupWindow(String title, String file) {
        myTitle = title;
        myContent = file;
    }

    public void display() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(myTitle);

        WebView browser = new WebView();
        URL url = this.getClass().getClassLoader().getResource(myContent);
        browser.getEngine().load(url.toExternalForm());

        Pane myPane = new Pane();
        myPane.getChildren().add(browser);

        Scene myScene = new Scene(myPane);
        window.setScene(myScene);
        window.show();
    }
}
