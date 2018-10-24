package model;

import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * @Author Yunhao Qing
 */

public class Turtle implements TurtleInterface {

    private double xPos;
    private double yPos;
    private double orientation;
    private boolean visibility;

    private Color penColor;
    private double penWidth;
    private boolean penVisibility;

    private List<Line> lines;

    public Turtle(double initialX, double initialY, Color color) {
        xPos = initialX;
        yPos = initialY;

        orientation = 90.0;
        visibility = true;

        penColor = color;
        penWidth = 1.0;

        lines = new ArrayList<>();
    }

    public double getX(){
        return xPos;
    }
    public double getY(){
        return yPos;
    }
    public void move(double distance){
        double newX = xPos + distance * Math.cos(Math.toRadians(orientation));
        double newY = yPos + distance * Math.sin(Math.toRadians(orientation));
        moveTo(newX,newY);
        System.out.println("The turtle is now at " + xPos + " " + yPos);
    }

    public void moveTo(double newX, double newY){
        addLine(new Line(xPos, yPos, newX, newY));
        xPos = newX;
        yPos = newY;
    }

    public double getOrientation(){
        return orientation;
    }
    public void turn(double degree){
        orientation = (orientation + degree);
        while (orientation > 360.0){
            orientation -= 360.0;
        }
    }
    public void setOrientation(double newOrientation){ orientation = newOrientation; }

    public boolean getVisibility(){
        return visibility;
    }
    public void setVisibility(boolean visibility){
        this.visibility = visibility;
    }

    public Color getPenColor(){
        return penColor;
    }

    public double getPenWidth(){
        return penWidth;
    }

    public void setPenWidth(double width){
        penWidth = width;
    }

    public void setPenColor(Color color){
        penColor = color;
    }

    public List<Line> getLines() {
        return lines;
    }

    public boolean getPenVisibility(){
        return penVisibility;
    }
    public void setPenVisibility(boolean visibility){
        penVisibility = visibility;
    }

    private void addLine(Line line) {
        if (getPenVisibility()){
            line.setStroke(penColor);
            line.setStrokeWidth(penWidth);
            lines.add(line);
        }
    }

    public void clearLines() {
        lines = new ArrayList<Line>();
    }

}