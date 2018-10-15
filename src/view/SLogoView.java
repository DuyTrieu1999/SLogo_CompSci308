package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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

    public Scene sceneInit () {
        initVariable();
        myBP = new BorderPane();
        myBP.setLeft(addButton());
        myBP.setRight(addScriptView());
        myBP.setCenter(addLogoView());
        myRoot.getChildren().add(myBP);
        System.out.println(myBP.getLeft());
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
        VBox buttonPane = new VBox();
        buttonPane.getChildren().add(new LogoButton("sthg", event -> testing()));
        buttonPane.getChildren().add(new DropDownButtons());
        return buttonPane;
    }
    public HBox addScriptView () {
        return null;
    }
    public HBox addLogoView () {
        HBox viewBox = new HBox();

        return null;
    }
    public void testing () {
        return;
    }
}
