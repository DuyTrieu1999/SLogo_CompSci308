package model;

import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * This class is Turtle for the back end.
 * @Author Yunhao Qing
 */

public class Turtle implements TurtleInterface {

    private double xPos;
    private double yPos;
    private double orientation;
    private boolean visibility;

    private Color penColor;
    private double penWidth;
    private boolean penVisibility = true;
    private boolean hasImageChanged = false;

    private List<Line> lines;

    private int id;
    private int imageID;

    /**
     * Construct the turtle.
     * @param initialX
     * @param initialY
     * @param color
     * @param id
     */
    public Turtle(double initialX, double initialY, Color color, int id) {
        xPos = initialX;
        yPos = initialY;

        orientation = 90.0;
        visibility = true;

        penColor = color;
        penWidth = 1.0;

        lines = new ArrayList<>();

        this.id = id;
        imageID = 1;
    }

    /**
     * @return turtle id.
     */
    public int getID(){ return id;}

    /**
     * @return image id.
     */
    public int getImageID(){ return imageID;}

    /*
     * @return x position.
     */
    public double getX(){
        return xPos;
    }

    /*
     * @return y position.
     */
    public double getY(){
        return yPos;
    }

    /**
     * Move by a certain distance
     * @param distance the distance
     */
    public void move(double distance){
        double newX = xPos + distance * Math.cos(Math.toRadians(orientation));
        double newY = yPos + distance * Math.sin(Math.toRadians(orientation));
        moveTo(newX,newY);
    }

    /**
     * Move to a certain position.
     * @param newX x index
     * @param newY y index
     */

    public void moveTo(double newX, double newY){
        addLine(new Line(xPos, yPos, newX, newY));
        xPos = newX;
        yPos = newY;
    }

    /**
     * @return Orientation
     */
    public double getOrientation(){
        return orientation;
    }

    /**
     * Turn by a certain degree
     * @param degree the degree
     */
    public void turn(double degree){
        orientation = (orientation + degree);
        while (orientation > 360.0){
            orientation -= 360.0;
        }
    }

    /**
     * Set the orientation to a certain value
     * @param newOrientation the new orientation
     */
    public void setOrientation(double newOrientation){ orientation = newOrientation; }

    /**
     * @return visibility
     */
    public boolean getVisibility(){
        return visibility;
    }

    /**
     * Set visibility
     * @param visibility the visibility
     */
    public void setVisibility(boolean visibility){
        this.visibility = visibility;
    }

    /**
     * @return penColor
     */
    public Color getPenColor(){
        return penColor;
    }
    /**
     * @return penWidth
     */
    public double getPenWidth(){
        return penWidth;
    }

    /**
     * Set penWidth
     * @param width penWidth
     */
    public void setPenWidth(double width){
        penWidth = width;
    }

    /**
     * Set pen color
     * @param color the pen color
     */
    public void setPenColor(Color color){
        penColor = color;
    }

    /**
     * @return the lines ploted.
     */
    public List<Line> getLines() {
        return lines;
    }

    /**
     * @return penVisibility
     */
    public boolean getPenVisibility(){
        return penVisibility;
    }

    /**
     * Set visibility
     * @param visibility pen visibility
     */
    public void setPenVisibility(boolean visibility){
        penVisibility = visibility;
    }

    /**
     * Add a line is pine is set to visible.
     * @param line the line to be added to the list.
     */
    private void addLine(Line line) {
        if (getPenVisibility()){
            line.setStroke(penColor);
            line.setStrokeWidth(penWidth);
            lines.add(line);
        }
    }

    /**
     * Clear all the lines.
     */
    public void clearLines() {
        lines = new ArrayList<>();
    }

    /**
     * Change the image for turtle.
     * @param id the image id
     */
    public void changeImage(int id){
        setHasImageChanged(true);
        imageID = id;
    }

    /**
     * Set the hasImageChanged to val
     * @param val boolean value
     */
    public void setHasImageChanged(boolean val){
        hasImageChanged = val;
    }

    /**
     * @return image status
     */
    public boolean getImageStatus(){
        return hasImageChanged;
    }

}