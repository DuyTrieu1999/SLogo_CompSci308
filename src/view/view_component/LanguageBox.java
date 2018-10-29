package view.view_component;

import javafx.scene.control.ChoiceBox;

import java.util.ResourceBundle;

/**
 * LanguageBox
 *
 * @author brookekeene
 */
class LanguageBox extends ChoiceBox<String> {
    private static final int DROPDOWN_WIDTH = 200;
    private static final String DEFAULT_LANGUAGE = "English";
    private static final String RESOURCE_PACKAGE = "text/view";
    private ResourceBundle myResources;

    LanguageBox() {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        this.setPrefWidth(DROPDOWN_WIDTH);
    }

    void makeBox() { //TODO: use reflection
        this.getItems().add(myResources.getString("Chinese"));
        this.getItems().add(myResources.getString("English"));
        this.getItems().add(myResources.getString("French"));
        this.getItems().add(myResources.getString("German"));
        this.getItems().add(myResources.getString("Italian"));
        this.getItems().add(myResources.getString("Portuguese"));
        this.getItems().add(myResources.getString("Russian"));
        this.getItems().add(myResources.getString("Spanish"));
        this.getItems().add(myResources.getString("Urdu"));

        this.setValue(DEFAULT_LANGUAGE);
    }

    String getChoice() {
        return this.getValue();
    }
}
