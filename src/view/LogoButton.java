package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class LogoButton extends Button {

    public LogoButton (String buttonName, EventHandler<ActionEvent> event) {
        this.setText(buttonName);
        this.setMinWidth(SceneENUM.BUTTON_GRID.getVal());
        this.setMaxWidth(SceneENUM.BUTTON_GRID.getVal());
        this.setOnAction(event);
    }
}