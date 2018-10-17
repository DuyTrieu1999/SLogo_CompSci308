package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

import java.util.ResourceBundle;

public class SLogoView {
    private static final double FRAMES_PER_SECOND = 1;
    private static final double MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    private static final double SECOND_DELAY = 100.0/ FRAMES_PER_SECOND;
    private static final Paint BACKGROUND = Color.WHITE;
    public static final String RESOURCE_PACKAGE = "resources/text/view";
    public static final String STYLESHEET = "default.css";

    private Scene myScene;
    private Group myRoot;
    private Timeline animation = new Timeline();
    private KeyFrame frame;
    private BorderPane myBP;
    private LogoScreen logoScreen;
    private DropDownButtons dropDownButtons;
    private ResourceBundle myResources;

    public Scene sceneInit () {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        initVariable();
        myBP = new BorderPane();
        myBP.setPadding(new Insets(Integer.parseInt(myResources.getString("Padding")))); //TODO: put magic values in resource file
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
        myScene = new Scene(myRoot, Integer.parseInt(myResources.getString("Scene_Width")), Integer.parseInt(myResources.getString("Scene_Height")), BACKGROUND);
        myScene.getStylesheets().add(STYLESHEET);
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
        return null;
    }
    public VBox addLogoView () {
        VBox logoBox = new VBox();
        HBox buttonBox = new HBox();
        logoScreen = new LogoScreen();
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Play"), event -> startButtonHandler()));
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Stop"), event -> stopButtonHandler()));
        buttonBox.getChildren().add(new LogoButton(myResources.getString("Step"), event -> stepButtonHandler()));
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
}
