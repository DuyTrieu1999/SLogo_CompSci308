package view.view_component;

import javafx.scene.control.ChoiceBox;

import java.util.ResourceBundle;

/**
 * LanguageBox
 *
 * @author brookekeene
 */
public class LanguageBox extends ChoiceBox<String> {
    public static final int DROPDOWN_WIDTH = 200;
    public static final String DEFAULT_LANGUAGE = "English";
    public static final String RESOURCE_PACKAGE = "text/view";
    private ResourceBundle myResources;

    public LanguageBox() {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        this.setPrefWidth(DROPDOWN_WIDTH);
    }

    public void makeBox() { //TODO: use reflection
        this.getItems().add(myResources.getString("Chinese"));
        this.getItems().add(myResources.getString("English"));
        this.getItems().add(myResources.getString("French"));
        this.getItems().add(myResources.getString("German"));
        this.getItems().add(myResources.getString("Italian"));
        this.getItems().add(myResources.getString("Portuguese"));
        this.getItems().add(myResources.getString("Russian"));
        this.getItems().add(myResources.getString("Spanish"));

        this.setValue(DEFAULT_LANGUAGE);
    }

    public String getChoice() {
        return this.getValue();
    }
}
