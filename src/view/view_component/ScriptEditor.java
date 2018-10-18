package view.view_component;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class ScriptEditor extends VBox {
    private TextArea myScriptEditor;
    public ScriptEditor() {
        myScriptEditor = new TextArea();
        this.setId("script-editor");
        this.getChildren().add(myScriptEditor);
    }
}
