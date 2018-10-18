package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.util.ResourceBundle;

public class DropDownButtons extends VBox {
    public static final String RESOURCE_PACKAGE = "resources/text/view";
    private ResourceBundle myResources;
    private ChoiceBox<String> langCB;
    private TextFlow historyTab;

    public DropDownButtons() {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        this.setId("dropdown-menu");
        this.getChildren().add(addControls());
        this.getChildren().add(addDisplay());
        this.getChildren().add(addTurtleSetting());
        this.getChildren().add(addVariables());
        this.getChildren().add(addUserCommand());
        this.getChildren().add(addLanguage());
        this.getChildren().add(addHistoryTab());
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
        HBox displayBox = displayControl();
        display.setText("Display");
        display.setContent(displayBox);
        display.setExpanded(false);
        return display;
    }
    private HBox displayControl () {
        HBox controlTab = new HBox();
        RadioButton blueButton = new RadioButton("Blue");
        RadioButton blackButton = new RadioButton("Black");
        RadioButton redButton = new RadioButton("Red");
        controlTab.getChildren().addAll(blackButton, blueButton, redButton);
        return controlTab;
    }
    private TitledPane addTurtleSetting () {
        TitledPane turtleSetting = new TitledPane();
        HBox turtleBox = displayTurtle();
        turtleSetting.setText("Turtle Setting");
        turtleSetting.setContent(turtleBox);
        turtleSetting.setExpanded(false);
        return turtleSetting;
    }
    private HBox displayTurtle () {
        HBox turtleTab = new HBox();

        return turtleTab;
    }
    private TitledPane addVariables () {
        TitledPane variable = new TitledPane();
        HBox varBox = displayVariable();
        variable.setText("Variables");
        variable.setContent(varBox);
        variable.setExpanded(false);
        return variable;
    }
    private HBox displayVariable () {
        HBox variableTab = new HBox();
        RadioButton bluePen = new RadioButton("Blue");
        RadioButton blackPen = new RadioButton("Black");
        variableTab.getChildren().addAll(blackPen, bluePen);
        return variableTab;
    }
    private TitledPane addUserCommand () {
        TitledPane userCommand = new TitledPane();
        VBox userBox = displayUserCommand();
        userCommand.setText("User Commands");
        userCommand.setContent(userBox);
        userCommand.setExpanded(false);
        return userCommand;
    }
    private VBox displayUserCommand () {
        VBox userCommandTab = new VBox();
        return userCommandTab;
    }
    private TitledPane addHistoryTab () {
        TitledPane history = new TitledPane();
        VBox historyBox = historyWindow();
        history.setText("History");
        history.setContent(historyBox);
        history.setExpanded(false);
        return history;
    }
    private VBox historyWindow () {
        VBox history = new VBox();
        historyTab = new TextFlow();
        historyTab.setTextAlignment(TextAlignment.JUSTIFY);
        historyTab.setLineSpacing(5.0);
        Text text = new Text("Now this is a text node");
        history.getChildren().add(text);
        history.getChildren().add(historyTab);
        return history;
    }
}
