package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import model.Turtle;

public class TurtleDriver {
    public static final String DEFAULT_IMAGE = "turtle.png";
    public static final String IMAGE_PATH = "resources/images/";
    private ImageView myImage;
    private Turtle myTurtle;
    private int turtleID; // when multiple turtles arise
    public static double initX = 250;
    public static double initY = 275;
    private double xPos;
    private double yPos;
    private double orientation;

    public TurtleDriver() {
        myTurtle = new Turtle(initX, initY, Color.BLACK);
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_IMAGE));
        myImage = new ImageView(image);
        xPos = myTurtle.getX();
        yPos = myTurtle.getY();
        orientation = myTurtle.getOrientation();
    }

    public ImageView getTurtleImage() {
        return this.myImage;
    }

    public void setTurtleImage(Image im) {
        myImage = new ImageView(im);
    }

    public double getX() {
        return xPos;
    }

    public double getY() {
        return yPos;
    }

    public void updateX(double newX) {
        xPos = newX;
    }

    public void updateY(double newY) {
        yPos = newY;
    }
}
