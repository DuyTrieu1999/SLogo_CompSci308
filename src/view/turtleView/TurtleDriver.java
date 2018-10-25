package view.turtleView;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import model.Turtle;
import view.view_component.LogoScreen;

import java.util.LinkedList;

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
    private Point2D myLocation;
    private double orientation;


    /**
     * Constructor
     */

    public TurtleDriver(LogoScreen screen, int id, Image image) {
        myScreen = screen;
        turtleID = id;
       // myLocation = new Point2D(myScreen.getMyPane().getPrefWidth()/2, myScreen.getMyPane().getPrefHeight()/2);
        myPen = new Pen(myScreen, Color.BLACK, 1, 1);
        myDestination = new Destination();
        myImage = new ImageView(image);
//        myImage.setX(myLocation.getX());
//        myImage.setY(myLocation.getY());
        myImage.setFitWidth(100);
        myImage.setFitHeight(100);
//        orientation = myTurtle.getOrientation();
    }

    public ImageView getTurtleImage() {
        return myImage;
    }

    public Point2D getLocation () { return new Point2D(myImage.getX(), myImage.getX()); }

    public void setTurtleImage(Image im) {
        myImage.setImage(null);
        myImage = new ImageView(im);
    }

    public void setLocation(Point2D curr, Point2D next) {
        myImage.setX(next.getX());
        myImage.setY(next.getY());
        setCenter(next);
        myPen.drawLine(curr, next);
    }
    public void updateMove() {
        LinkedList<Point2D> destinations = myDestination.getMyFutureDestination();
        int stepsToDestination = destinations.size();
        int i = 0;
        if (i < stepsToDestination) {
            this.setLocation(destinations.get(i), destinations.get(i+1));
            i++;
        }
    }
    public void updateMovement(Point2D destination) {
        myDestination.addFutureDestination(destination);
    }
    public void setPoint (Point2D point) {
        myLocation = point;
    }

    public double getX() { return myImage.getX(); }

    public double getY() { return myImage.getY(); }

    public double getHeading() { return orientation; }

    public void setHeading(double degree) { orientation = degree; }

    public void setMyPenColor(Color c) {
        myPen.setColor(c);
    }

    public void turn(double degree) { myImage.setRotate(degree); }

    public Destination getMyDestination () { return myDestination; }

    public void setCenter (Point2D center) {
        myImage.setX(center.getX() - myImage.getBoundsInLocal().getWidth() / 2);
        myImage.setY(center.getY() - myImage.getBoundsInLocal().getHeight() / 2);
    }
}
