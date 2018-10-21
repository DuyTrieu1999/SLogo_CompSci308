package controller;

import javafx.scene.paint.Color;
import model.CommandList;
import model.CommandListInterface;
import model.CommandParser;
import model.TurtleInterface;
import view.SLogoView;
import view.SLogoViewAPI;
import view.turtleView.TurtleDriver;

import java.util.List;

/**
 * Controller
 *
 * class that connects the front end and the back end
 *
 * @author duytrieu
 */
public class Controller implements SLogoViewAPI, CommandListInterface {
    SLogoView myView;
    CommandList myCommand;

    public Controller (SLogoView view) {
        myView = view;
        myCommand = new CommandList();
    }
    public SLogoView getView () {
        return myView;
    }
    /**
     * Controller
     *
     * from SLogoAPI
     */
    public void clearConsole() {
        myView.clearConsole();
    }
    /**
     * Controller
     *
     * from SLogoAPI
     */
    public void clearDisplay() {
        myView.clearDisplay();
    }
    /**
     * Controller
     *
     * from SLogoAPI
     */
    public void showMessage(String text) {
        myView.showMessage(text);
    }
    /**
     * Controller
     *
     * from SLogoAPI
     */
    public void clearHistory() {
        myView.clearHistory();
    }
    /**
     * Controller
     *
     * from SLogoAPI
     */
    public TurtleDriver getTurtle() {
        return myView.getTurtle();
    }
    public String getCommand() {
        return myCommand.getCommand();
    }
    public List<String> getCommands() {
        return myCommand.getCommands();
    }

    public void setLanguage (String language) {
        myCommand.setLanguage(language);
    }

    public String getLanguage() {
        return myCommand.getLanguage();
    }

    public void setMessage (String message) {
        myCommand.setMessage(message);
    }
}
