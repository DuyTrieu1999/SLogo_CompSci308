package view.view_component;

import javafx.geometry.Point2D;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.turtleView.TurtleDriver;

import java.util.ResourceBundle;

public class LogoScreen extends VBox {
    private static final String DEFAULT_IMAGE = "blackturtle.png";
    private static final String IMAGE_PATH = "slogo_team08/resources/images/";
    private static final String RESOURCE_PACKAGE = "/text/view";
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
        myTurtle = new TurtleDriver(this, 0, new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE)));
        setUpTurtle(myTurtle);
        this.setBackGroundColor(backgroundColor);
        myPane.setPrefWidth(Integer.parseInt(myResources.getString("Canvas_Width")));
        myPane.setPrefHeight(Integer.parseInt(myResources.getString("Canvas_Height")));
        this.getChildren().add(myPane);
    }
    public void setUpTurtle (TurtleDriver turtle) {
        turtle.getView().setLayoutX(200);
        turtle.getView().setLayoutY(200);
        myBackGround.getChildren().add(myTurtle.getView());
    }

    public void updateTurtle () {
        myTurtle.updateMove();
    }

    public void setMyBackGround (int width, int height) {
        myBackGround = new Pane();
        myBackGround.setPrefSize(width, height);
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
    protected boolean isInBounds(Point2D point) {
        return (point.getX() >= (-myBackGround.getWidth() / 2.0) && point.getX() <= (myBackGround.getWidth() / 2.0)
                && point.getY() >= (-myBackGround.getHeight() / 2.0) && point.getY() <= (myBackGround.getHeight() / 2.0));
    }
    public void clear () {
        this.getChildren().clear();
    }
    public Pane getMyPane () {
        return myBackGround;
    }
    public TurtleDriver getMyTurtle () {
        return myTurtle;
    }
}

