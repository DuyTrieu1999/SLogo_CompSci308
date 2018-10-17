package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.ResourceBundle;

public class LogoButton extends Button {
    public static final String RESOURCE_PACKAGE = "resources/text/view";
    private ResourceBundle myResources;

    public LogoButton (String buttonName, EventHandler<ActionEvent> event) {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);

        this.setText(buttonName);
        this.setMinWidth(Integer.parseInt(myResources.getString("Button_Grid")));
        this.setMaxWidth(Integer.parseInt(myResources.getString("Button_Grid")));
        this.setOnAction(event);
    }
}