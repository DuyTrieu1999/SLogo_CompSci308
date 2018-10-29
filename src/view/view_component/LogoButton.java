package view.view_component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class LogoButton extends Button {

    /**
     * @Author Duy Trieu
     */

    private static final int BUTTON_GRID = 60;

    public LogoButton (String buttonName, EventHandler<ActionEvent> event) {
        this.setText(buttonName);
        this.setMinWidth(BUTTON_GRID);
        this.setMaxWidth(BUTTON_GRID);
        this.setOnAction(event);
    }
}