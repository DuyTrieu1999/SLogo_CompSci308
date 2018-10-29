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
    private LogoScreen myScreen;
    private Pen myPen;
    private Graphic myGraphic;
    private int turtleID;
    private double orientation;
    private boolean isActive;

    /**
     * Constructor
     */

    public TurtleDriver(LogoScreen screen, int id, Image image, Turtle turtle) {
        myTurtle = turtle;
        myScreen = screen;
        turtleID = id;
        isActive = true;
        myPen = new Pen(myScreen, id, turtle);
        myGraphic = new Graphic(id, image);
        myGraphic.getView().setX(turtle.getX());
        myGraphic.getView().setY(turtle.getY());
        myGraphic.setImageInactive(isActive);
    }

    public Point2D getLocation () { return new Point2D(myTurtle.getX(), myTurtle.getY()); }

    public void setTurtleImage(Image im) {
        myGraphic = new Graphic(turtleID, im);
    }

    public Turtle getMyTurtle () {
        return myTurtle;
    }

    public boolean isActive () { return isActive; }
    public void setActive (boolean active) { isActive = active; }

    private void setLocation(Point2D next) {
        this.setPoint(next);
    }
    public Pen getPen() {return myPen;}
    public void updateMove() {
        List<Line> lineList = myTurtle.getLines();
        for (Line line: lineList) {
            myPen.drawLine(line);
        }
        setLocation(getLocation());
        setRotation(myTurtle.getOrientation());
    }

    public void setPoint (Point2D point) {
        myGraphic.getView().setX(point.getX());
        myGraphic.getView().setY(point.getY());
    }
    public int getTurtleID () {
        return turtleID;
    }
    public double getOrientation () {
        return myTurtle.getOrientation();
    }
    public double getX() { return myGraphic.getView().getX(); }

    public double getY() { return myGraphic.getView().getY(); }

    public double getHeading() { return orientation; }

    public Graphic getMyGraphic () { return myGraphic; }

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
