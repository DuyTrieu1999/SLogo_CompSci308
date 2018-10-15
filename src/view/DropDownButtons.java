package view;

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
        this.getChildren().add(addDisplay());
        this.getChildren().add(addTurtleSetting());
        this.getChildren().add(addVariables());
        this.getChildren().add(addUserCommand());
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
        TitledPane control = new TitledPane();
        VBox controlBox = new VBox();
        controlBox.getChildren().add(new Button("bla"));
        controlBox.getChildren().add(new Button("bla"));
        control.setText("Controls");
        control.setContent(controlBox);
        control.setExpanded(false);
        return control;
    }
    private TitledPane addDisplay () {
        TitledPane display = new TitledPane();
        VBox displayBox = new VBox();
        display.setText("Display");
        display.setContent(displayBox);
        display.setExpanded(false);
        return display;
    }
    private TitledPane addTurtleSetting () {
        TitledPane turtleSetting = new TitledPane();
        VBox turtleBox = new VBox();
        turtleSetting.setText("Display");
        turtleSetting.setContent(turtleBox);
        turtleSetting.setExpanded(false);
        return turtleSetting;
    }
    private TitledPane addVariables () {
        TitledPane variable = new TitledPane();
        VBox varBox = new VBox();
        variable.setText("Display");
        variable.setContent(varBox);
        variable.setExpanded(false);
        return variable;
    }
    private TitledPane addUserCommand () {
        TitledPane userCommand = new TitledPane();
        VBox userBox = new VBox();
        userCommand.setText("Display");
        userCommand.setContent(userBox);
        userCommand.setExpanded(false);
        return userCommand;
    }
}
