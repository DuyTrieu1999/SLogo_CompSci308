package model;

import javafx.scene.paint.Color;

public interface TurtleInterface {
        double getX();
        double getY();
        void move(double distance);
        void moveTo(double x, double y);

        double getOrientation();
        void turn(double degree);

        boolean getVisibility();
        void setVisibility(boolean visibility);

        Color getPenColor();
        void setPenColor(Color color);

}
