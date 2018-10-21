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
    private Point2D location;
    private double orientation;


    /**
     * Constructor
     */

    public TurtleDriver(LogoScreen screen, int id, Image image) {
        myScreen = screen;
        turtleID = id;
        myPen = new Pen(myScreen, Color.BLACK, 1, 1);
        myDestination = new Destination();
        myImage = new ImageView(image);
        myImage.setX(screen.getMyPane().getLayoutX() / 2);
        myImage.setY(screen.getMyPane().getLayoutY() / 2);
        location = new Point2D(myImage.getX(), myImage.getY());
        myImage.setFitWidth(100);
        myImage.setFitHeight(100);
//        orientation = myTurtle.getOrientation();
    }

    public ImageView getTurtleImage() {
        return myImage;
    }

    public Point2D getLocation () { return location; }

    public void setTurtleImage(Image im) {
        myImage = new ImageView(im);
    }

    public void setDestination(Point2D destination) {
        double distX = destination.getX() - this.getX();
        double distY = destination.getY() - this.getY();
        myDestination.setMyDestination(destination);
    }
    public void setLocation(Point2D location) {
        System.out.println(location.getX());
        System.out.println(location.getY());
        myImage.setX(location.getX());
        myImage.setY(location.getY());
        System.out.println("bla: " + myImage.getX());
        System.out.println("bla: " + myImage.getY());
        System.out.println("width: " + myScreen.getMyPane().getLayoutX()/2);
        System.out.println("height: " + myScreen.getMyPane().getLayoutY()/2);
        setCenter(location);
    }

    public double getX() { return location.getX(); }

    public double getY() { return location.getY(); }

    public double getHeading() { return orientation; }

    public void setHeading(double degree) { orientation = degree; }

    public void turn(double degree) { myImage.setRotate(degree); }

    public Destination getMyDestination () { return myDestination; }

    public void setCenter (Point2D center) {
        myImage.setX(center.getX() - myImage.getBoundsInLocal().getWidth() / 2);
        myImage.setY(center.getY() - myImage.getBoundsInLocal().getHeight() / 2);
    }
}
