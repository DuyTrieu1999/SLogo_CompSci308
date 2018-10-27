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

import java.util.ArrayList;
import java.util.ResourceBundle;

public class LogoScreen extends VBox {
    private static final String DEFAULT_IMAGE = "blackturtle.png";
    private static final String IMAGE_PATH = "slogo_team08/resources/images/";
    private static final String RESOURCE_PACKAGE = "/text/view";
    private ResourceBundle myResources;
    private StackPane myPane;
    private Pane myBackGround;
    private TurtleManager turtleManager;
    private Controller myController;

    private int numberOfTurtle = 3;

    public LogoScreen (Color backgroundColor, Controller controller) {
        myController = controller;
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        this.setId("main-screen");
        myBackGround = new Pane();
        myPane = new StackPane();
        setMyBackGround(Integer.parseInt(myResources.getString("Canvas_Width")),
                Integer.parseInt(myResources.getString("Canvas_Height")));
        Image turtleImage = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE));
        turtleManager = new TurtleManager(numberOfTurtle, turtleImage, this);
        System.out.println(turtleManager.getActiveTurtle());
        this.setBackGroundColor(backgroundColor);
        myPane.setPrefWidth(Integer.parseInt(myResources.getString("Canvas_Width")));
        myPane.setPrefHeight(Integer.parseInt(myResources.getString("Canvas_Height")));
        this.getChildren().add(myPane);
    }
    public Controller getController () {
        return myController;
    }

    public void addElement (Node element) {
        element.setLayoutX(250);
        element.setLayoutY(250);
        myBackGround.getChildren().add(element);
    }
    public void addTurtle (TurtleDriver turtle) {
        turtle.getView().setLayoutX(200);
        turtle.getView().setLayoutY(200);
        myBackGround.getChildren().add(turtle.getView());
    }

    public void updateTurtle () {
        for (TurtleDriver turtle: turtleManager.getActiveTurtle()) {
            turtle.updateMove();
        }
    }

    public void setMyBackGround (int width, int height) {
        myBackGround = new Pane();
        myBackGround.setPrefSize(width, height);
        myBackGround.setScaleY(-1.0);
        Rectangle clipBoundaries = new Rectangle();
        clipBoundaries.widthProperty().bind(myBackGround.widthProperty());
        clipBoundaries.heightProperty().bind(myBackGround.heightProperty());
        myBackGround.setClip(clipBoundaries);
        myPane.getChildren().add(myBackGround);
    }

    public void setBackGroundColor (Color backGroundColor) {
        BackgroundFill primaryLayer = new BackgroundFill(backGroundColor, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(primaryLayer);
        myBackGround.setBackground(background);
    }

    public Color getBackGroundColor () {
        return (Color) myBackGround.getBackground().getFills().get(0).getFill();
    }
    public void clear () {
        if (myController.setTurtleSupplier().getLines().size() == 0) {
            this.getChildren().clear();
            turtleManager.clearTurtle();
        }
    }
    public Pane getMyPane () {
        return myBackGround;
    }
    public ArrayList<TurtleDriver> getMyTurtle () {
        return turtleManager.getActiveTurtle();
    }
}

