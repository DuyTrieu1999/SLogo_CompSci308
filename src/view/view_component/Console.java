package view.view_component;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class Console extends VBox {
    private TextFlow myConsole;
    public Console () {
        this.setId("console-screen");
        ScrollPane sp = new ScrollPane();
        myConsole = new TextFlow();
        myConsole.setTextAlignment(TextAlignment.JUSTIFY);
        myConsole.setLineSpacing(5.0);
        sp.setContent(myConsole);
        this.getChildren().add(sp);
    }
    public void addText(Text text) {
        myConsole.getChildren().add(text);
    }
    public TextFlow getConsole() {
        return myConsole;
    }
}
