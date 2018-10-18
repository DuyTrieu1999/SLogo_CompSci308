package view.view_component;

import javafx.geometry.Point2D;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import view.TurtleView.TurtleDriver;

import java.util.ResourceBundle;

public class LogoScreen extends VBox {
    public static final String RESOURCE_PACKAGE = "resources/text/view";
    private ResourceBundle myResources;
    private StackPane myPane;
    private Pane myBackGround;
    private TurtleDriver turtleManager;

    public LogoScreen (Color backgroundColor) {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        this.setId("main-screen");
        myBackGround = new Pane();
        myPane = new StackPane();
        turtleManager = new TurtleDriver();
        setMyBackGround(Integer.parseInt(myResources.getString("Canvas_Width")),
                Integer.parseInt(myResources.getString("Canvas_Height")));
        setUpTurtle();
        setBackGroundColor(backgroundColor);
        myPane.setPrefWidth(Integer.parseInt(myResources.getString("Canvas_Width")));
        myPane.setPrefHeight(Integer.parseInt(myResources.getString("Canvas_Height")));
        this.getChildren().add(myPane);
    }
    public void setUpTurtle () {
        turtleManager = new TurtleDriver();
        myPane.getChildren().add(turtleManager.getTurtleImage());
    }
    public void updateTurtle () {
        Point2D turtlePos = new Point2D(turtleManager.getX(), turtleManager.getY());
        if (isInBounds(turtlePos)) {

        }
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
    public Color getColor () {
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
}

