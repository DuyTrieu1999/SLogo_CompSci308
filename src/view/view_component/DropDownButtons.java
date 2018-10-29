package view.view_component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import view.turtleView.TurtleDriver;
import view.turtleView.TurtleInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * DropDownButtons
 *
 * @author brookekeene
 */
public class DropDownButtons extends VBox {
    public static final int DROPDOWN_WIDTH = 200;
    public static final String RESOURCE_PACKAGE = "text/view";
    public static final String PATH_TO_LANGUAGES = "languages/";
    public static final String HELP_DOCUMENT = "commands.html";
    private ResourceBundle myResources;
    private ResourceBundle myLanguages;
    private ChoiceBox<String> langCB;
    private TextFlow historyTab;
    private TextFlow variablesTab;
    private TextFlow userTab;
    private LogoScreen myDisplay;
    private Controller myController;

    /**
     * Constructors
     */
    public DropDownButtons(LogoScreen ls, Controller controller) {
        myDisplay = ls;
        myController = controller;
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);

        historyTab = new TextFlow();
        historyTab.setMaxWidth(DROPDOWN_WIDTH);
        historyTab.setTextAlignment(TextAlignment.JUSTIFY);
        historyTab.setLineSpacing(5.0);

        this.setId("dropdown-menu");
        //TODO: make this a separate method?
        this.getChildren().add(addControls());
        this.getChildren().add(addBackgroundTab());
        this.getChildren().add(addPenTab());
        this.getChildren().add(addTurtleTab());
        this.getChildren().add(addTurtleState());
        this.getChildren().add(addHistoryTab());
        this.getChildren().add(addVariablesTab());
        this.getChildren().add(addUserCommandTab());
        this.getChildren().add(addLanguageTab());
        this.getChildren().add(addHelpTab());
    }

    /**
     * adds heading to the control panel dropdown menu
     * @return HBox containing Label for header
     */
    private HBox addControls() {
        HBox controlHeader = new HBox();
        controlHeader.setPadding(new Insets(Integer.parseInt(myResources.getString("Padding"))));
        controlHeader.setAlignment(Pos.CENTER_LEFT);
        Label header = new Label();
        header.setText(myResources.getString("Control"));
        controlHeader.getChildren().add(header);
        return controlHeader;
    }

    /**
     * adds background tab containing controls for background settings
     * @return TitledPane containing background controls
     */
    private TitledPane addBackgroundTab() {
        TitledPane backgroundTab = new TitledPane();
        VBox backBox = backgroundSettings();
        backgroundTab.setText(myResources.getString("Background"));
        backgroundTab.setContent(backBox);
        backgroundTab.setExpanded(false);
        return backgroundTab;
    }

    /**
     * creates a VBox containing the background controls (color)
     * @return VBox containing pre-defined ColorBox
     */
    private VBox backgroundSettings() {
        VBox backgroundControls = new VBox();
        Label color = new Label(myResources.getString("ColorChoice"));
        ColorBox colorChoices = new ColorBox();
        colorChoices.makeBox();
        colorChoices.setOnAction(e -> {
            String newBackColor = colorChoices.getColor();
            myDisplay.setBackGroundColor(Color.valueOf(newBackColor));
        });
        backgroundControls.getChildren().addAll(color, colorChoices);
        return backgroundControls;
    }

    /**
     * adds pen tab containing controls for pen settings
     * @return TitledPane containing pen controls
     */
    private TitledPane addPenTab() {
        TitledPane penTab = new TitledPane();
        VBox penBox = penSettings();
        penTab.setText(myResources.getString("Pen"));
        penTab.setContent(penBox);
        penTab.setExpanded(false);
        return penTab;
    }

    /**
     * creates a VBox containing the pen controls (color)
     * @return VBox containing pre-defined ColorBox
     */
    private VBox penSettings() {
        VBox penControls = new VBox();
        Label color = new Label(myResources.getString("ColorChoice"));
        ColorBox colorChoices = new ColorBox();
        colorChoices.makeBox();
        colorChoices.setOnAction(e -> {
            String newPenColor = colorChoices.getColor();
            myDisplay.getMyTurtle().setMyPenColor(Color.valueOf(newPenColor));
        });
        penControls.getChildren().addAll(color, colorChoices);
        return penControls;
    }

    /**
     * adds turtle tab containing controls for turtle settings
     * @return TitledPane containing turtle controls
     */
    private TitledPane addTurtleTab() {
        TitledPane turtleSetting = new TitledPane();
        VBox turtleBox = turtleSettings();
        turtleSetting.setText(myResources.getString("Turtle"));
        turtleSetting.setContent(turtleBox);
        turtleSetting.setExpanded(false);
        return turtleSetting;
    }

    /**
     * creates a VBox containing the turtle controls (image)
     * @return VBox containing pre-defined ImageChooser
     */
    private VBox turtleSettings() {
        VBox turtleControls = new VBox();
        ImageChooser imageBox = new ImageChooser();
        Button chooserBtn = imageBox.getButton();
        chooserBtn.setOnAction(value -> {
            File file = imageBox.getFileChooser().showOpenDialog(getScene().getWindow());
            //TODO: error check
            if(file.toString().contains(".png") || file.toString().contains(".jpeg")) {
                imageBox.setFileName(file.toString());
                Image myImage = new Image(file.toURI().toString());
                myDisplay.getMyTurtle().getView().setImage(myImage);
            }
        });
        turtleControls.getChildren().add(imageBox);
        return turtleControls;
    }
    private TitledPane addTurtleState() {
        TitledPane turtleState = new TitledPane();
        VBox turtleStateBox = turtleState();
        turtleState.setText(myResources.getString("State"));
        turtleState.setContent(turtleStateBox);
        turtleState.setExpanded(false);
        return turtleState;
    }

    private VBox turtleState() {
        VBox turtleStateBox = new VBox();
        TurtleDriver myTurtles = myDisplay.getMyTurtle();
        turtleStateBox.getChildren().add(new TurtleInfo(myTurtles));
        return turtleStateBox;
    }


    /**
     * adds history tab containing the user's input command history
     * @return TitledPane containing the command history
     */
    private TitledPane addHistoryTab() {
        TitledPane history = new TitledPane();
        VBox historyBox = displayHistory();
        history.setText(myResources.getString("History"));
        history.setContent(historyBox);
        history.setExpanded(false);
        return history;
    }

    /**
     *
     * @return
     */
    private VBox displayHistory() {
        VBox history = new VBox();
        ScrollPane scroller = new ScrollPane();
        scroller.setMaxHeight(DROPDOWN_WIDTH);
        scroller.setContent(historyTab);
        history.getChildren().add(scroller);
        return history;
    }

    /**
     *
     * @param command
     */
    public void editHistoryTab(String command) {
        Text text = new Text(command + "\n");
        historyTab.getChildren().add(text);
    }

    /**
     * adds variables tab containing the variables available to the user
     * @return TitledPane containing available variables
     */
    private TitledPane addVariablesTab() {
        TitledPane variables = new TitledPane();
        VBox varBox = displayVariable();
        variables.setText(myResources.getString("Variables"));
        variables.setContent(varBox);
        variables.setExpanded(false);
        return variables;
    }

    /**
     *
     * @return
     */
    private VBox displayVariable() {
        VBox variables = new VBox();
        variablesTab = new TextFlow();
        variablesTab.setTextAlignment(TextAlignment.JUSTIFY);
        variablesTab.setLineSpacing(5.0);
        variables.getChildren().addAll(variablesTab);
        return variables;
    }

    /**
     * adds user-defined commands tab containing the user's pre-defined commands
     * @return TitledPane containing the user-defined commands
     */
    private TitledPane addUserCommandTab() {
        TitledPane userCommands = new TitledPane();
        VBox userBox = displayUserCommands();
        userCommands.setText(myResources.getString("UserCommands"));
        userCommands.setContent(userBox);
        userCommands.setExpanded(false);
        return userCommands;
    }

    /**
     *
     * @return
     */
    private VBox displayUserCommands() {
        VBox commands = new VBox();
        userTab = new TextFlow();
        userTab.setTextAlignment(TextAlignment.JUSTIFY);
        userTab.setLineSpacing(5.0);
        return commands;
    }

    //TODO: display new colors in palette
    private TitledPane addPaletteTab() {
        TitledPane paletteTab = new TitledPane();
        this.paletteDefault();
        paletteTab.setText(myResources.getString("Palette"));
        paletteTab.setContent(paletteBox);
        paletteTab.setExpanded(false);
        return paletteTab;
    }

    private void paletteDefault() {
//        Label colorLbl = new Label(myResources.getString("ColorDefault"));
//        paletteBox.getChildren().add(colorLbl);
//        for (int i: myPalette.keySet()) {
//            Text temp = new Text(i + " = " + myPalette.getColorMap().get(i));
//            paletteBox.getChildren().add(temp);
//        }
    }

    public void editPalette(int index, int r, int g, int b) {
        myPalette.addColor(index, r, g, b);
        Text temp = new Text(index + " = " + myPalette.getColorMap().get(index));
        paletteBox.getChildren().add(temp);
    }

    /**
     * adds languages tab containing controls for the languages understood for commands
     * @return TitledPane containing language controls
     */
    private TitledPane addLanguageTab() {
        TitledPane languageTab = new TitledPane();
        VBox languageBox = languageSettings();
        languageTab.setText(myResources.getString("Language"));
        languageTab.setContent(languageBox);
        languageTab.setExpanded(false);
        return languageTab;
    }

    /**
     * creates a VBox containing the language controls (command language)
     * @return VBox containing ChoiceBox
     */
    private VBox languageSettings() {
        VBox languageControls = new VBox();
        Label langChoice = new Label(myResources.getString("LanguageChoice"));
        LanguageBox languageCB = new LanguageBox();
        languageCB.makeBox();
        languageCB.setOnAction(e -> {
            String newLanguage = languageCB.getChoice();
            ResourceBundle newLangResources = ResourceBundle.getBundle(PATH_TO_LANGUAGES + newLanguage);
            myController.setLanguageConsumer(newLangResources);
        });
        languageControls.getChildren().addAll(langChoice, languageCB);
        return languageControls;
    }

    public void getChoice() {
        String name = langCB.getValue();
        String filePath = PATH_TO_LANGUAGES + name;
        myLanguages = ResourceBundle.getBundle(filePath);
        myController.setLanguageConsumer(myLanguages);
    }

    /**
     * adds help tab containing a link that directs the user to a command reference page
     * @return TitledPane containing reference link
     */
    private TitledPane addHelpTab() {
        TitledPane helpTab = new TitledPane();
        HBox helpBox = new HBox();
        Hyperlink helpLink = new Hyperlink(myResources.getString("HelpBasic"));
        helpLink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PopupWindow helpWindow = new PopupWindow(myResources.getString("HelpBasic"), HELP_DOCUMENT);
                helpWindow.display();
            }
        });
        helpBox.getChildren().addAll(helpLink);
        helpTab.setText(myResources.getString("Help"));
        helpTab.setContent(helpBox);
        helpTab.setExpanded(false);
        return helpTab;
    }
}
