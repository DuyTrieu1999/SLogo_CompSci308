package view.turtleView;

import javafx.geometry.Point2D;

import java.util.LinkedList;
import java.util.Queue;

public class Destination {
    private Point2D myDestination;
    private LinkedList<Point2D> myFutureDestination;

    public Destination () {
        myDestination = new Point2D(0,0);
        myFutureDestination = new LinkedList<>();
    }

    public Point2D getMyDestination() {
        return myDestination;
    }
    public void setMyDestination(Point2D destination) {
        myDestination = destination;
    }
    public void addFutureDestination(Point2D destination) {
        myFutureDestination.add(destination);
    }
    public Point2D getDestinationInList() {
        return myFutureDestination.poll();
    }
    public LinkedList<Point2D> getMyFutureDestination() {
        return myFutureDestination;
    }
}
