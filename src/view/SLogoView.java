package view;

import controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.CommandList;
import model.VariableMap;
import view.turtleView.TurtleDriver;
import view.view_component.*;

import java.util.ResourceBundle;

/**
 * SLogoView
 *
 * main UI class that connects all elements
 *
 * @author duytrieu
 * @author brookekeene
 */
public class SLogoView extends HBox implements SLogoViewAPI {
    private static final double FRAMES_PER_SECOND = 1;
    private static final double MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 100.0/ FRAMES_PER_SECOND;
    private static final String RESOURCE_PACKAGE = "/text/view";

    private Timeline animation = new Timeline();
    private KeyFrame frame;
    private BorderPane myBP;
    private LogoScreen logoScreen;
    private DropDownButtons dropDownButtons;
    private ScriptEditor scriptView;
    private Console consoleView;
    private ResourceBundle myResources;
    private Controller myController;
    private CommandList myHistory;
    private int numOfTurtle = 3;
    private VariableMap myVariables;

    public SLogoView() {
        myController = new Controller(this);
        sceneInit();
    }
    public Controller getMyController () {
        return myController;
    }

    public void sceneInit () {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        logoScreen = new LogoScreen(Color.WHITE, myController, numOfTurtle);
        myHistory = new CommandList(myController);
        myVariables = myHistory.getMyVariables();
        initVariable();
        VBox scriptView = addScriptView();
        VBox logoView = addLogoView();
        myBP = new BorderPane();
        myBP.setPadding(new Insets(Integer.parseInt(myResources.getString("Padding"))));
        myBP.setLeft(addButton());
        myBP.setRight(scriptView);
        myBP.setCenter(logoView);
        this.getChildren().add(myBP);
    }
    private void initVariable () {
        frame  = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
                e -> this.step(SECOND_DELAY));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
    }
    private void step (double elapsedTime) {
        logoScreen.updateTurtle();
    }
    private VBox addButton () {
        dropDownButtons = new DropDownButtons(logoScreen, myController);
        dropDownButtons.makeTabs();
        VBox buttonPane = new VBox();
        ScrollPane sp = new ScrollPane();
        int width = Integer.parseInt(myResources.getString("Scroller_Width"));
        int height = Integer.parseInt(myResources.getString("Dropdown_Height"));
        sp.setMaxSize(width, height);
        sp.setContent(dropDownButtons);
        buttonPane.getChildren().add(sp);
        return buttonPane;
    }
    private VBox addScriptView () {
        VBox scriptViewBox = new VBox();
        HBox buttonBox = new HBox();
        scriptView = new ScriptEditor();
        consoleView = new Console();
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Run"), event -> runScript()));
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Clear"), event -> clearScript()));
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Load"), event -> loadScript()));
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Save"), event -> saveScript()));
        scriptViewBox.getChildren().add(scriptView);
        scriptViewBox.getChildren().add(buttonBox);
        scriptViewBox.getChildren().add(consoleView);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        return scriptViewBox;
    }
    private VBox addLogoView () {
        VBox logoBox = new VBox();
        HBox buttonBox = new HBox();
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Play"), event -> startButtonHandler()));
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Stop"), event -> stopButtonHandler()));
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Step"), event -> stepButtonHandler()));
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Add"), event -> addTurtle()));
        logoBox.getChildren().add(logoScreen);
        logoBox.getChildren().add(buttonBox);
        buttonBox.setAlignment(Pos.CENTER);
        return logoBox;
    }

    public void clearConsole() {
        this.clearScript();
    }

    public void clearDisplay() {
        logoScreen.clear();
    }

    public void clearHistory() {
        scriptView.clearEditor();
    }

    public void showMessage(String text) {
        consoleView.addText(new Text(text));
    }

    private void startButtonHandler () {
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.playFromStart();
    }

    private void stopButtonHandler () {
        animation.pause();;
    }
    private void stepButtonHandler () {
        stopButtonHandler();
        logoScreen.updateTurtle();
    }
    private void addTurtle () {
        numOfTurtle++;
        clearDisplay();
    }

    /**
     * processes the user input
     */
    public void runScript () {
        String command = scriptView.getUserInput();
        myController.setParseConsumer(command);
        myHistory.addCommand(command);
        dropDownButtons.editHistoryTab(command);
        dropDownButtons.editVariableTab();
        dropDownButtons.editUserCommandTab();
        myController.getMessageConsumer(myController.setOutputSupplier());
    }

    /**
     * clears the user input
     */
    public void clearScript () {
        consoleView.getConsole().getChildren().clear();
        scriptView.clearEditor();
    }
    private void loadScript () {

    }
    private void saveScript () {
//        //TODO: Print history
//        Queue<String> myQueue = myHistory.getHistory();
//        while(myQueue.peek() != null) {
//            String h = myQueue.poll();
//            System.out.println(h);
//        }
    }
}
