package model;

import javafx.scene.paint.Color;

/**
 * @Author Yunhao Qing
 */

public interface TurtleInterface {
        public double getX();
        public double getY();
        public double getOrientation();
        public boolean getVisibility();
        public Color getPenColor();
        public boolean getPenVisibility();
}
