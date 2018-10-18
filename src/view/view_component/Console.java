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
        this.getChildren().add(myConsole);
    }
    public void addText(Text text) {
        myConsole.getChildren().add(text);
    }
    public TextFlow getConsole() {
        return myConsole;
    }
}
