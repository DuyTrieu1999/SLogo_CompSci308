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

    private Turtle myTurtle;
    private LogoScreen myScreen;
    private Pen myPen;
    private Destination myDestination;
    private Graphic myGraphic;
    private int turtleID; // when multiple turtles arise
    private Point2D myLocation;
    private double orientation;


    /**
     * Constructor
     */

    public TurtleDriver(LogoScreen screen, int id, Image image) {
        myTurtle = new Turtle(0, 0, Color.WHITE);
        myScreen = screen;
        turtleID = id;
        myPen = new Pen(myScreen, Color.BLACK, 1, 1, true);
        myDestination = new Destination();
        myGraphic = new Graphic(id, image);
    }

    public Graphic getTurtleImage() {
        return myGraphic;
    }

    public Point2D getLocation () { return new Point2D(myGraphic.getView().getX(), myGraphic.getView().getX()); }

    public void setTurtleImage(Image im) {
        myGraphic = new Graphic(turtleID, im);
    }

    public void setLocation(Point2D curr, Point2D next) {
        getView().setX(next.getX());
        getView().setY(next.getY());
        myPen.drawLine(curr, next);
    }
    public void updateMove() {
        setPoint(new Point2D(getView().getX(), getView().getY()));
        while (myDestination.getDestinationInList() != null) {
           setLocation(myLocation, myDestination.getDestinationInList());
           setPoint(myDestination.getDestinationInList());
        }
    }
    public void updateMovement(Point2D destination) {
        myDestination.addFutureDestination(destination);
    }

    public Destination getDestination () { return this.myDestination; }

    public void setPoint (Point2D point) {
        myLocation = point;
    }

    public double getX() { return myGraphic.getView().getX(); }

    public double getY() { return myGraphic.getView().getY(); }

    public double getHeading() { return orientation; }

    public void setHeading(double degree) { orientation = degree; }

    public void setMyPenColor(Color c) {
        myPen.setColor(c);
    }

    public boolean isVisible() {
        return myGraphic.isVisible();
    }

    public void setVisible(boolean visible) {
        myGraphic.setVisible(visible);
    }

    public ImageView getView() {
        return myGraphic.getView();
    }

    public Destination getMyDestination () { return myDestination; }
    public void setRotation (double degrees) {
        myGraphic.setRotation(degrees);
    }
}
