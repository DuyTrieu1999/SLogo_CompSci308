package view;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;

public class ScriptEditor extends TextArea {
    public ScriptEditor() {
        this.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");
        this.setPrefSize(SceneENUM.TEXT_EDITOR_WIDTH.getVal(), SceneENUM.TEXT_EDITOR_HEIGHT.getVal());
        this.setPadding(new Insets(SceneENUM.BUTTON_PADDING.getVal()));
    }
}
