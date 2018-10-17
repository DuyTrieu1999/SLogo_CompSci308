package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.util.ResourceBundle;

public class DropDownButtons extends VBox {
    public static final String RESOURCE_PACKAGE = "resources/text/view";
    private ResourceBundle myResources;
    private ChoiceBox<String> langCB;

    public DropDownButtons() {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        this.setId("dropdown-menu");
        this.getChildren().add(addControls());
        this.getChildren().add(addLanguage());
    }
    private ChoiceBox addLanguage () {
        langCB = new ChoiceBox<>();
        langCB.setPrefWidth(Integer.parseInt(myResources.getString("Dropdown_Width")));
        langCB.getItems().add(myResources.getString("Chinese")); //TODO: find better way to list all choices rather than just hardcoding
        langCB.getItems().add(myResources.getString("English"));
        langCB.getItems().add(myResources.getString("French"));
        langCB.getItems().add(myResources.getString("German"));
        langCB.getItems().add(myResources.getString("Italian"));
        langCB.getItems().add(myResources.getString("Portuguese"));
        langCB.getItems().add(myResources.getString("Russian"));
        langCB.getItems().add(myResources.getString("Spanish"));
        langCB.setValue("English");
        langCB.setOnAction(e -> getChoice(langCB));
        return langCB;
    }
    private void getChoice(ChoiceBox<String> cb) {
        String name = cb.getValue();
    }
    private TitledPane addControls () {
        TitledPane tp = new TitledPane();
        VBox controlBox = new VBox();
        controlBox.getChildren().add(new Button("bla"));
        controlBox.getChildren().add(new Button("bla"));
        tp.setText(myResources.getString("Controls"));
        tp.setContent(controlBox);
        tp.setExpanded(false);
        return tp;
    }
}
