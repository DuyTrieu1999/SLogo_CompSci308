package view.turtleView;

import javafx.scene.image.Image;
import view.view_component.LogoScreen;

import java.util.Map;

public class TurtleManager {
    private Map<Integer, TurtleDriver> turtleMap;
    private int initialTurtles;
    private LogoScreen screen;
    private TurtleDriver currentTurtle;
    private Image turtleImage;

    public TurtleManager (int initNumber, Image turtleImage, LogoScreen screen) {
        this.initialTurtles = initNumber;
        this.turtleImage = turtleImage;
        this.screen = screen;
    }

    public Map<Integer, TurtleDriver> getAllTurtles() {
        return turtleMap;
    }

    public void setCurrentTurtle(TurtleDriver turtle) {
        currentTurtle = turtle;
    }
}
