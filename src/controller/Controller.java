package controller;

import javafx.scene.paint.Color;
import model.TurtleInterface;
import view.SLogoViewAPI;
import view.turtleView.TurtleDriver;

public class Controller implements SLogoViewAPI, TurtleInterface {
    public Controller () {

    }
    public double getX() {
        return 0;
    }

    public double getY() {return 0;}
    public double getOrientation() {return 0;}
    public boolean getVisibility() {return true;}
    public Color getPenColor() {return null;}
    public boolean getPenVisibility() { return true;}
    public void clearConsole() {}
    public void clearDisplay() {}
    public void showMessage(String text) {}
    public void resetSetting() {}
    public void resetTurtle() {}
    public void clearHistory() {}
    public TurtleDriver getTurtle() {return null;}
}
