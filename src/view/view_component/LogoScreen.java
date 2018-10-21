package view.view_component;

import javafx.geometry.Point2D;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import view.turtleView.TurtleDriver;

import java.util.LinkedList;
import java.util.ResourceBundle;

public class LogoScreen extends VBox {
    private static final String DEFAULT_IMAGE = "turtle.png";
    private static final String IMAGE_PATH = "slogo_team08/resources/images/";
    private static final String RESOURCE_PACKAGE = "text/view";
    private ResourceBundle myResources;
    private StackPane myPane;
    private Pane myBackGround;
    private TurtleDriver myTurtle;

    public LogoScreen (Color backgroundColor) {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        this.setId("main-screen");
        myBackGround = new Pane();
        myPane = new StackPane();
        setMyBackGround(Integer.parseInt(myResources.getString("Canvas_Width")),
                Integer.parseInt(myResources.getString("Canvas_Height")));
        setUpTurtle();
        this.setBackGroundColor(backgroundColor);
        myPane.setPrefWidth(Integer.parseInt(myResources.getString("Canvas_Width")));
        myPane.setPrefHeight(Integer.parseInt(myResources.getString("Canvas_Height")));
        this.getChildren().add(myPane);
    }
    public void setUpTurtle () {
        myTurtle = new TurtleDriver(this, 0, new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE)));
        myBackGround.getChildren().add(myTurtle.getTurtleImage());
    }
    public void updateTurtle () {
        LinkedList<Point2D> destinations = myTurtle.getMyDestination().getMyFutureDestination();
        for (Point2D point: destinations) {
            myTurtle.setLocation(point);
        }
    }
    public void updateMovement(Point2D destination) {
        myTurtle.getMyDestination().addFutureDestination(destination);
    }
    public void setMyBackGround (int width, int height) {
        myBackGround = new Pane();
        myBackGround.setMaxSize(width, height);
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
    protected boolean isInBounds(Point2D point) {
        return (point.getX() >= (-myBackGround.getWidth() / 2.0) && point.getX() <= (myBackGround.getWidth() / 2.0)
                && point.getY() >= (-myBackGround.getHeight() / 2.0) && point.getY() <= (myBackGround.getHeight() / 2.0));
    }
    public void clear () {
        this.getChildren().clear();
    }
    public StackPane getMyPane () {
        return myPane;
    }
    public TurtleDriver getMyTurtle () {
        return myTurtle;
    }
}

