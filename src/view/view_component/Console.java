package view.view_component;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class Console extends VBox {
    private TextFlow myConsole;
    public Console () {
        this.setId("console-screen");
        myConsole = new TextFlow();
        myConsole.setTextAlignment(TextAlignment.JUSTIFY);
        myConsole.setLineSpacing(5.0);
        Text text = new Text("Now this is a text node");
        myConsole.getChildren().add(text);
        this.getChildren().add(myConsole);
    }
}
