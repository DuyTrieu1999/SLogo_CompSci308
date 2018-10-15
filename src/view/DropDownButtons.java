package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class DropDownButtons extends VBox {
    private ChoiceBox<String> langCB;

    public DropDownButtons() {
        this.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: black;");
        this.getChildren().add(addControls());
        this.getChildren().add(addLanguage());
    }
    private ChoiceBox addLanguage () {
        langCB = new ChoiceBox<>();
        langCB.setPrefWidth(SceneENUM.DROPDOWN_WIDTH.getVal());
        langCB.getItems().add("English");
        langCB.getItems().add("French");
        langCB.getItems().add("Spanish");
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
        tp.setText("Controls");
        tp.setContent(controlBox);
        tp.setExpanded(false);
        return tp;
    }
}
