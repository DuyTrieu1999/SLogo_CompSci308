package view;

import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class Console extends TextFlow {
    public Console () {
        this.setTextAlignment(TextAlignment.JUSTIFY);
        this.setPrefSize(SceneENUM.TEXT_EDITOR_WIDTH.getVal(), SceneENUM.TEXT_EDITOR_HEIGHT.getVal());
        this.setPadding(new Insets(SceneENUM.BUTTON_PADDING.getVal()));
        this.setLineSpacing(5.0);
        Text text = new Text("Now this is a text node");
        this.getChildren().add(text);
    }
}
