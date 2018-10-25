package view;

import controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import model.CommandList;
import view.turtleView.TurtleDriver;
import view.view_component.*;

import java.util.Queue;
import java.util.ResourceBundle;

/**
 * SLogoView
 *
 * main UI class that connects all elements
 *
 * @author duytrieu
 * @author brookekeene
 */
public class SLogoView implements SLogoViewAPI {
    private static final double FRAMES_PER_SECOND = 1;
    private static final double MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 100.0/ FRAMES_PER_SECOND;
    private static final Paint BACKGROUND = Color.WHITE;
    private static final String RESOURCE_PACKAGE = "/text/view";
    private static final String STYLESHEET = "default.css";

    private Scene myScene;
    private Group myRoot;
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

    public Scene sceneInit () {
        myController = new Controller(this);
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        myHistory = new CommandList(myController);
        initVariable();
        VBox scriptView = addScriptView();
        VBox logoView = addLogoView();
        myBP = new BorderPane();
        myBP.setPadding(new Insets(Integer.parseInt(myResources.getString("Padding"))));
        myBP.setLeft(addButton());
        myBP.setRight(scriptView);
        myBP.setCenter(logoView);
        myRoot.getChildren().add(myBP);
        testing();
        return myScene;
    }
    private void initVariable () {
        frame  = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
                e -> this.step(SECOND_DELAY));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        myRoot = new Group();
        myScene = new Scene(myRoot, Integer.parseInt(myResources.getString("Scene_Width")),
                Integer.parseInt(myResources.getString("Scene_Height")), BACKGROUND);
        myScene.getStylesheets().add(STYLESHEET);
    }
    private void testing() {
        TurtleDriver turtle = logoScreen.getMyTurtle();
        turtle.updateMovement(new Point2D(turtle.getTurtleImage().getX(), turtle.getTurtleImage().getY()));
        turtle.updateMovement(new Point2D(turtle.getTurtleImage().getX() + 100, turtle.getTurtleImage().getY()));
        turtle.updateMovement(new Point2D(turtle.getX() + 100, turtle.getY() + 100));
        turtle.updateMovement(new Point2D(turtle.getTurtleImage().getX(), turtle.getTurtleImage().getY() + 100));
    }
    private void step (double elapsedTime) {
        logoScreen.updateTurtle();
        TurtleDriver turtle = logoScreen.getMyTurtle();
    }
    private VBox addButton () {
        dropDownButtons = new DropDownButtons(logoScreen, myController);
        VBox buttonPane = new VBox();
        buttonPane.getChildren().add(dropDownButtons);
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
        logoScreen = new LogoScreen(Color.WHITE);
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Play"), event -> startButtonHandler()));
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Stop"), event -> stopButtonHandler()));
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Step"), event -> stepButtonHandler()));
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

    }

    public TurtleDriver getTurtle() {
        return null;
    }


    public void setLanguage (String language) {

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

    /**
     * processes the user input
     */
    public void runScript () {
        String command = scriptView.getUserInput();
        myController.setParseConsumer(command);
        System.out.println(command);
        myHistory.addCommand(command);
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
        //TODO: Print history
        Queue<String> myQueue = myHistory.getHistory();
        while(myQueue.peek() != null) {
            String h = myQueue.poll();
            System.out.println(h);
        }
    }
}
