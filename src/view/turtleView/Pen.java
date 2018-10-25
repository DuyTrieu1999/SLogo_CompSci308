package view.turtleView;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.Turtle;
import view.view_component.LogoScreen;

public class Pen {
    private LogoScreen myScreen;
    private Color myColor;
    private double myThickness;
    private int penIndex;
    private boolean isDown;
    private Turtle turtle;

    public Pen (LogoScreen screen, int index, Turtle turtle) {
        this.isDown = turtle.getPenVisibility();
        this.myScreen = screen;
        this.myColor = turtle.getPenColor();
        this.myThickness = turtle.getPenWidth();
        this.penIndex = index;
        this.turtle = turtle;
    }

    protected void drawLine (Line line) {
        myScreen.addElement(line);
    }

    protected Color getColor() {
        return myColor;
    }

    protected void setColor(Color color) {
        myColor = color;
    }

    protected int getColorIndex() {
        return penIndex;
    }

    protected void setColorIndex(int index) {
        penIndex = index;
    }

    protected void setThickness(double width) {
        myThickness = width;
    }

    public boolean isDown () { return isDown; }

    protected void setDown (boolean down) { isDown = down; }
}
