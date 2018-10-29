package view.turtleView;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.Turtle;
import view.view_component.LogoScreen;

import java.util.List;

/**
 * TurtleDriver
 *
 * @author brookekeene
 * @author Duy Trieu
 */
public class TurtleDriver {

    private Turtle myTurtle;
    private Pen myPen;
    private Graphic myGraphic;
    private int turtleID;
    private double orientation;
    private boolean isActive;

    /**
     * Constructor
     */

    TurtleDriver(LogoScreen screen, int id, Image image, Turtle turtle) {
        myTurtle = turtle;
        turtleID = id;
        isActive = true;
        myPen = new Pen(screen, id, turtle);
        myGraphic = new Graphic(image);
        myGraphic.getView().setX(turtle.getX());
        myGraphic.getView().setY(turtle.getY());
        myGraphic.setImageInactive(true);
    }

    private Point2D getLocation() { return new Point2D(myTurtle.getX(), myTurtle.getY()); }

    public Turtle getMyTurtle () {
        return myTurtle;
    }

    boolean isActive() { return isActive; }
    void setActive (boolean active) { isActive = active; }

    private void setLocation(Point2D next) {
        this.setPoint(next);
    }
    Pen getPen() {return myPen;}
    public void updateMove() {
        List<Line> lineList = myTurtle.getLines();
        for (Line line: lineList) {
            myPen.drawLine(line);
        }
        setLocation(getLocation());
        setRotation(myTurtle.getOrientation());
    }

    private void setPoint(Point2D point) {
        myGraphic.getView().setX(point.getX());
        myGraphic.getView().setY(point.getY());
    }
    int getTurtleID() {
        return turtleID;
    }
    double getOrientation() {
        return myTurtle.getOrientation();
    }
    public double getX() { return myGraphic.getView().getX(); }

    public double getY() { return myGraphic.getView().getY(); }

    public double getHeading() { return orientation; }

    Graphic getMyGraphic() { return myGraphic; }

    public void setHeading(double degree) { orientation = degree; }

    public void setMyPenColor(Color c) {
        myPen.setColor(c);
    }

    public ImageView getView() {
        return myGraphic.getView();
    }

    private void setRotation(double degrees) {
        myGraphic.setRotation(degrees);
    }
}
