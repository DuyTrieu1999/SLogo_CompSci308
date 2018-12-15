package model;

import javafx.scene.paint.Color;

/**
 * This class is a turtle interface for the front end to use.
 * @author Yunhao Qing
 */

public interface TurtleInterface {
        double getX();
        double getY();
        double getOrientation();
        boolean getVisibility();
        Color getPenColor();
        boolean getPenVisibility();
}
