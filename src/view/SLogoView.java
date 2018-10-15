package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

public class SLogoView {
    private double FRAMES_PER_SECOND = 1;
    private double MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private double SECOND_DELAY = 100.0/ FRAMES_PER_SECOND;
    private static final Paint BACKGROUND = Color.AZURE;

    private Scene myScene;
    private Group myRoot;
    private Timeline animation = new Timeline();
    private KeyFrame frame;
    private BorderPane myBP;
    private LogoScreen logoScreen;
    private DropDownButtons dropDownButtons;
    private ScriptEditor scriptView;
    private Console consoleView;

    public Scene sceneInit () {
        initVariable();
        myBP = new BorderPane();
        myBP.setLeft(addButton());
        myBP.setRight(addScriptView());
        myBP.setCenter(addLogoView());
        myRoot.getChildren().add(myBP);
        return myScene;
    }
    public void initVariable () {
        frame  = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
                e -> this.step(SECOND_DELAY));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        myRoot = new Group();
        myScene = new Scene(myRoot, SceneENUM.SCENE_WIDTH.getVal(), SceneENUM.SCENE_HEIGHT.getVal(), BACKGROUND);
    }
    public void step (double elapsedTime) {

    }
    public VBox addButton () {
        dropDownButtons = new DropDownButtons();
        VBox buttonPane = new VBox();
        buttonPane.getChildren().add(dropDownButtons);
        return buttonPane;
    }
    public VBox addScriptView () {
        VBox scriptViewBox = new VBox();
        HBox buttonBox = new HBox();
        scriptView = new ScriptEditor();
        consoleView = new Console();
        buttonBox.getChildren().add(new LogoButton("Run", event -> runScript(scriptView)));
        buttonBox.getChildren().add(new LogoButton("Clear", event -> clearScript(scriptView)));
        buttonBox.getChildren().add(new LogoButton("Load", event -> loadScript()));
        buttonBox.getChildren().add(new LogoButton("Save", event -> saveScript(scriptView)));
        scriptViewBox.getChildren().add(scriptView);
        scriptViewBox.getChildren().add(buttonBox);
        scriptViewBox.getChildren().add(consoleView);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        return scriptViewBox;
    }
    public VBox addLogoView () {
        VBox logoBox = new VBox();
        HBox buttonBox = new HBox();
        logoScreen = new LogoScreen();
        buttonBox.getChildren().add(new LogoButton("Play", event -> startButtonHandler()));
        buttonBox.getChildren().add(new LogoButton("Stop", event -> stopButtonHandler()));
        buttonBox.getChildren().add(new LogoButton("Step", event -> stepButtonHandler()));
        logoBox.getChildren().add(logoScreen);
        logoBox.getChildren().add(buttonBox);
        buttonBox.setAlignment(Pos.CENTER);
        return logoBox;
    }
    public void startButtonHandler () {
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.playFromStart();
    }
    public void stopButtonHandler () {
        animation.pause();;
    }
    public void stepButtonHandler () {
        return;
    }
    public void runScript (ScriptEditor textArea) {
        return;
    }
    public void clearScript (ScriptEditor textArea) {
        return;
    }
    public void loadScript () {
        return;
    }
    public void saveScript (ScriptEditor textArea) {
        return;
    }
}
