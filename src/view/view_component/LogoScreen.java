package view.view_component;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.turtleView.TurtleDriver;
import view.turtleView.TurtleManager;
import java.util.ResourceBundle;

/**
 * @Author Duy Trieu
 */

public class LogoScreen extends VBox {
    private static final String DEFAULT_IMAGE = "blackturtle.png";
    private static final int TURTLE_LAYOUT = 200;
    private static final int LINE_LAYOUT = 250;
    private static final String RESOURCE_PACKAGE = "/text/view";
    private StackPane myPane;
    private static Pane myBackGround;
    private TurtleManager turtleManager;
    private Controller myController;

    public LogoScreen (Color backgroundColor, Controller controller, int numberOfTurtle) {
        myController = controller;
        ResourceBundle myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        this.setId("main-screen");
        myBackGround = new Pane();
        myPane = new StackPane();
        setMyBackGround(Integer.parseInt(myResources.getString("Canvas_Width")),
                Integer.parseInt(myResources.getString("Canvas_Height")));
        Image turtleImage = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE));
        turtleManager = new TurtleManager(numberOfTurtle, turtleImage, this);
        setBackGroundColor(backgroundColor);
        myPane.setPrefWidth(Integer.parseInt(myResources.getString("Canvas_Width")));
        myPane.setPrefHeight(Integer.parseInt(myResources.getString("Canvas_Height")));
        this.getChildren().add(myPane);
    }
    public Controller getController () {
        return myController;
    }

    public void addElement (Node element) {
        element.setLayoutX(LINE_LAYOUT);
        element.setLayoutY(LINE_LAYOUT);
        myBackGround.getChildren().add(element);
    }
    public void addTurtle (TurtleDriver turtle) {
        turtle.getView().setLayoutX(TURTLE_LAYOUT);
        turtle.getView().setLayoutY(TURTLE_LAYOUT);
        myBackGround.getChildren().add(turtle.getView());
    }

    public void updateTurtle () {
        turtleManager.getActiveTurtle().updateMove();
    }

    private void setMyBackGround(int width, int height) {
        myBackGround = new Pane();
        myBackGround.setPrefSize(width, height);
        myBackGround.setScaleY(-1.0);
        Rectangle clipBoundaries = new Rectangle();
        clipBoundaries.widthProperty().bind(myBackGround.widthProperty());
        clipBoundaries.heightProperty().bind(myBackGround.heightProperty());
        myBackGround.setClip(clipBoundaries);
        myPane.getChildren().add(myBackGround);
    }

    public static void setBackGroundColor (Color backGroundColor) {
        BackgroundFill primaryLayer = new BackgroundFill(backGroundColor, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(primaryLayer);
        myBackGround.setBackground(background);
    }
    public void clear () {
//        if (turtleManager.getActiveTurtle().getMyTurtle().getLines().size() == 1) {
//            myBackGround.getChildren().clear();
//            turtleManager.clearTurtle();
//        }
        if (turtleManager.getActiveTurtle().getMyTurtle().getLines().size() == 0) {
            myBackGround.getChildren().clear();
            turtleManager.clearTurtle();
        }
//        Image turtleImage = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE));
//        turtleManager = new TurtleManager(numberOfTurtle, turtleImage, this);
    }
    TurtleDriver getMyTurtle() {
        return turtleManager.getActiveTurtle();
    }
}

