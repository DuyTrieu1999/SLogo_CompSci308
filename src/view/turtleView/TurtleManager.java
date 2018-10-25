package view.turtleView;

import javafx.scene.image.Image;
import model.Turtle;
import view.view_component.LogoScreen;

import java.util.HashMap;

public class TurtleManager {
    private HashMap<Integer, TurtleDriver> turtleMap;
    private int initialTurtles;
    private LogoScreen screen;
    private TurtleDriver currentTurtle;
    private Image turtleImage;
    private Turtle turtleModel;

    public TurtleManager (int initNumber, Image turtleImage, LogoScreen screen, Turtle turtle) {
        this.initialTurtles = initNumber;
        this.turtleImage = turtleImage;
        this.screen = screen;
        this.turtleModel = turtle;
    }

    public HashMap<Integer, TurtleDriver> getAllTurtles() {
        return turtleMap;
    }

    public void setCurrentTurtle(TurtleDriver turtle) {
        currentTurtle = turtle;
    }

    protected void setInitialTurtles () {
        for (int i=1; i <= initialTurtles; i++) {
            TurtleDriver turtle = new TurtleDriver(screen, i, turtleImage, turtleModel);
            turtleMap.put(i, turtle);
            screen.addElement(turtle.getView());
        }
    }
}
