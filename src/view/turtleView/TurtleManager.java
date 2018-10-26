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

    }
    protected TurtleDriver getTurtleByID (int id) {
        return turtleMap.get(id);
    }
    protected TurtleDriver getCurrentTurtle () {
        return currentTurtle;
    }
    private void createInitTurtle (int id) {
        TurtleDriver turtle = new TurtleDriver(screen, id, turtleImage, turtleModel);
        turtleMap.put(id, turtle);
        screen.addElement(turtle.getView());
        currentTurtle = turtle;
    }
}
