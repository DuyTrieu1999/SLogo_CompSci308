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

    private TurtleManager turtleManager;
    private Turtle myTurtle;
    private LogoScreen myScreen;
    private Pen myPen;
    private Graphic myGraphic;
    private int turtleID; // when multiple turtles arise
    private double orientation;


    /**
     * Constructor
     */

    public TurtleDriver(LogoScreen screen, int id, Image image, Turtle turtle) {
        myTurtle = turtle;
        myScreen = screen;
        turtleID = id;
        myPen = new Pen(myScreen, Color.BLACK, 1, 1, true);
        myGraphic = new Graphic(id, image);
    }

    public Graphic getTurtleImage() {
        return myGraphic;
    }

    public Point2D getLocation () { return new Point2D(myTurtle.getX(), myTurtle.getY()); }

    public void setTurtleImage(Image im) {
        myGraphic = new Graphic(turtleID, im);
    }

    private void setLocation(Point2D curr, Point2D next) {
        if (myPen.isDown()) {
            myPen.drawLine(curr, next);
        }
        this.setPoint(next);
    }
    public void updateMove() {
        Point2D myLocation = new Point2D(getX(), getY());
        setLocation(myLocation, getLocation());
        setRotation(myTurtle.getOrientation());
    }

    public void setPoint (Point2D point) {
        getView().setX(point.getX());
        getView().setY(point.getY());
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

    public void setRotation (double degrees) {
        myGraphic.setRotation(degrees);
    }
}
