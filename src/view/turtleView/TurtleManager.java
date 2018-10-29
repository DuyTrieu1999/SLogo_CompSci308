package view.turtleView;

import javafx.scene.image.Image;
import view.view_component.LogoScreen;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author Duy Trieu
 */

public class TurtleManager {
    private HashMap<Integer, TurtleDriver> turtleMap;
    private int initialTurtles;
    private LogoScreen screen;
    private Image turtleImage;
    private TurtleDriver activeTurtle;

    public TurtleManager (int initNumber, Image turtleImage, LogoScreen screen) {
        this.initialTurtles = initNumber;
        this.turtleImage = turtleImage;
        this.screen = screen;
        clearTurtle();
    }

    public HashMap<Integer, TurtleDriver> getAllTurtles() {
        return turtleMap;
    }

    protected TurtleDriver getTurtleByID (int id) {
        return turtleMap.get(id);
    }

    private void createInitTurtle (int id) {
        TurtleDriver turtle = new TurtleDriver(screen, id, turtleImage, screen.getController().setTurtleSupplier());
        turtleMap.put(id, turtle);
        screen.addTurtle(turtle);
        activeTurtle = turtle;
        for (TurtleDriver turtleDrive: turtleMap.values()) {
            if (turtleDrive != turtle) {
                turtleDrive.setActive(false);
                turtleDrive.getMyGraphic().setImageInactive(false);
            }
        }
        turtle.getView().setOnMouseClicked(e -> addActiveTurtle(turtle));
        turtle.setActive(true);
    }
    public void clearTurtle() {
        turtleMap = new HashMap<>();
        createListTurtle();
    }
    private void createListTurtle () {
        for (int i=1; i< initialTurtles+1; i++) {
            createInitTurtle(i);
        }
    }
    private void addActiveTurtle (TurtleDriver turtle) {
        if (!turtle.isActive()) {
            activeTurtle = turtle;
            turtle.setActive(true);
            turtle.getMyGraphic().setImageInactive(true);
            for (TurtleDriver turtleDrive: turtleMap.values()) {
                if (turtleDrive != turtle) {
                    turtleDrive.setActive(false);
                    turtleDrive.getMyGraphic().setImageInactive(false);
                }
            }
        }
        else {
            turtle.setActive(false);
            turtle.getMyGraphic().setImageInactive(false);
        }
    }
    public TurtleDriver getActiveTurtle () {
        return activeTurtle;
    }
}
