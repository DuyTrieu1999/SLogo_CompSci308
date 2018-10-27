package view.turtleView;

import javafx.scene.image.Image;
import model.Turtle;
import view.view_component.LogoScreen;

import java.util.ArrayList;
import java.util.HashMap;

public class TurtleManager {
    private HashMap<Integer, TurtleDriver> turtleMap;
    private int initialTurtles;
    private LogoScreen screen;
    private TurtleDriver currentTurtle;
    private Image turtleImage;
    private ArrayList<TurtleDriver> activeTurtle;

    public TurtleManager (int initNumber, Image turtleImage, LogoScreen screen) {
        this.initialTurtles = initNumber;
        this.turtleImage = turtleImage;
        this.screen = screen;
        clearTurtle();
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
        TurtleDriver turtle = new TurtleDriver(screen, id, turtleImage, screen.getController().setTurtleSupplier());
        turtleMap.put(id, turtle);
        screen.addTurtle(turtle);
        currentTurtle = turtle;
        activeTurtle.add(turtle);
        turtle.getView().setOnMouseClicked(e -> addActiveTurtle(turtle));
        turtle.setActive(true);
    }
    public void clearTurtle() {
        turtleMap = new HashMap<>();
        activeTurtle = new ArrayList<>();
        createListTurtle();
    }
    private void createListTurtle () {
        for (int i=1; i< initialTurtles+1; i++) {
            setTurtleActive(i, true);
        }
    }
    private void setTurtleActive (int id, boolean active) {
        if (turtleMap.containsKey(id)) {
            TurtleDriver turtle = turtleMap.get(id);

        }
        createInitTurtle(id);
    }
    private void addActiveTurtle (TurtleDriver turtle) {
        if (turtle.isActive())
            activeTurtle.add(turtle);
        else
            activeTurtle.remove(turtle);
    }
    public ArrayList<TurtleDriver> getActiveTurtle () {
        return activeTurtle;
    }
}
