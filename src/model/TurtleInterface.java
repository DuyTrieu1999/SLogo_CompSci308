package model;

import javafx.scene.paint.Color;

/**
 * @Author Yunhao Qing
 */

public interface TurtleInterface {
        double getX();
        double getY();
        double getOrientation();
        boolean getVisibility();
        Color getPenColor();
        boolean getPenVisibility();
}
