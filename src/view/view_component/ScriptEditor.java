package view.view_component;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 * ScriptEditor
 *
 * @author duytrieu
 * @author brookekeene
 */
public class ScriptEditor extends VBox {
    private TextArea myScriptEditor;

    /**
     * Constructor
     */
    public ScriptEditor() {
        myScriptEditor = new TextArea();
        this.setId("script-editor");
        this.getChildren().add(myScriptEditor);
    }

    /**
     *
     * @return text entered into TextArea
     */
    public String getUserInput() {
        return myScriptEditor.getText();
    }

    /**
     * clears the text from the TextArea
     */
    public void clearEditor() {
        myScriptEditor.clear();
    }
}
