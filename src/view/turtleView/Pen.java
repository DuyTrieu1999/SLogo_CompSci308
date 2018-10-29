package view.turtleView;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.Turtle;
import view.view_component.LogoScreen;

public class Pen {
    private LogoScreen myScreen;
    private Color myColor;
    private double myThickness;
    private boolean isDown;

    public Pen (LogoScreen screen, int index, Turtle turtle) {
        this.isDown = turtle.getPenVisibility();
        this.myScreen = screen;
        this.myColor = turtle.getPenColor();
        this.myThickness = turtle.getPenWidth();
    }

    void drawLine(Line line) {
        Line newLine = new Line(line.getStartX(),line.getStartY(), line.getEndX(), line.getEndY());
        newLine.setStroke(myColor);
        newLine.setStrokeWidth(myThickness);
        myScreen.addElement(newLine);
    }

    public Color getColor() {
        return myColor;
    }

    protected void setColor(Color color) {
        myColor = color;
    }

    double getThickness() { return myThickness; }

    boolean isDown () { return isDown; }
}
