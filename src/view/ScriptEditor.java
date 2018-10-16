package view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class ScriptEditor extends VBox {
    private TextArea myScriptEditor;
    public ScriptEditor() {
        myScriptEditor = new TextArea();
        this.setId("script-editor");
        myScriptEditor.setPrefSize(SceneENUM.TEXT_EDITOR_WIDTH.getVal(), SceneENUM.TEXT_EDITOR_HEIGHT.getVal());
        this.getChildren().add(myScriptEditor);
    }
}
