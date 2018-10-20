package view.turtleView;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import model.Turtle;
import view.view_component.LogoScreen;

/**
 * TurtleDriver
 *
 * @author brookekeene
 */
public class TurtleDriver {

    private ImageView myImage;
    private Turtle myTurtle;
    private LogoScreen myScreen;
    private Pen myPen;
    private Destination myDestination;
    private int turtleID; // when multiple turtles arise
    public static double initX = 250;
    public static double initY = 275;
    private double xPos;
    private double yPos;
    private double orientation;


    /**
     * Constructor
     */

    public TurtleDriver(LogoScreen screen, int id, Image image) {
        myScreen = screen;
        myTurtle = new Turtle(initX, initY, Color.BLACK);
        turtleID = id;
        myPen = new Pen(myScreen, Color.BLACK, 1, 1);
        myDestination = new Destination();
        myImage = new ImageView(image);
        myImage.setFitWidth(100);
        myImage.setFitHeight(100);
        xPos = myTurtle.getX();
        yPos = myTurtle.getY();
        orientation = myTurtle.getOrientation();
    }

    public ImageView getTurtleImage() {
        return myImage;
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

    public double getHeading() { return orientation; }

    public void setHeading(double degree) { orientation = degree; }

    public void turn(double degree) { myImage.setRotate(degree); }
}
