package view.turtleView;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import view.view_component.LogoScreen;

public class Pen {
    private LogoScreen myScreen;
    private Color myColor;
    private double myThickness;
    private int penIndex;

    public Pen (LogoScreen screen, Color color, double thickness, int index) {
        myScreen = screen;
        myColor = color;
        myThickness = thickness;
        penIndex = index;
    }

    protected void drawLine (Point2D start, Point2D finish) {
        Line line = new Line(start.getX(), start.getY(), finish.getX(), finish.getY());
        line.setStroke(myColor);
        line.setStrokeWidth(myThickness);
        myScreen.getMyPane().getChildren().add(line);
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
}
