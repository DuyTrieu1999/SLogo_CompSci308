package controller;

import javafx.scene.paint.Color;
import model.CommandParser;
import model.TurtleInterface;
import view.SLogoView;
import view.SLogoViewAPI;
import view.turtleView.TurtleDriver;

/**
 * Controller
 *
 * class that connects the front end and the back end
 *
 * @author duytrieu
 */
public class Controller implements SLogoViewAPI, TurtleInterface {
    SLogoView myView;
    CommandParser myParser;

    public Controller (SLogoView view) {
        myView = view;
    }
    public double getX() {
        return 0;
    }

    public double getY() {
        return 0;
    }
    public double getOrientation() {
        return 0;
    }
    public boolean getVisibility() {
        return true;
    }
    public Color getPenColor() {
        return null;
    }
    public boolean getPenVisibility() {
        return true;
    }
    public void clearConsole() {
        myView.clearConsole();
    }
    public void clearDisplay() {
        myView.clearDisplay();
    }
    public void showMessage(String text) {
        myView.showMessage(text);
    }
    public void clearHistory() {
        myView.clearHistory();
    }
    public TurtleDriver getTurtle() {
        return myView.getTurtle();
    }
}
