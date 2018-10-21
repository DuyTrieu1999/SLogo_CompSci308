package controller;

import model.CommandList;
import model.CommandListInterface;
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
    private SLogoView myView;
    private CommandList myCommand;

    public Controller (SLogoView view) {
        myView = view;
        myCommand = new CommandList();
    }
    public SLogoView getView () {
        return myView;
    }
    /**
     * clearConsole
     *
     * from SLogoAPI
     */
    public void clearConsole() {
        myView.clearConsole();
    }
    /**
     * clearDisplay
     *
     * from SLogoAPI
     */
    public void clearDisplay() {
        myView.clearDisplay();
    }
    /**
     * showMessage
     *
     * from SLogoAPI
     */
    public void showMessage(String text) {
        myView.showMessage(text);
    }
    /**
     * clearHistory
     *
     * from SLogoAPI
     */
    public void clearHistory() {
        myView.clearHistory();
    }
    /**
     * getTurtle
     *
     * from SLogoAPI
     */
    public TurtleDriver getTurtle() {
        return myView.getTurtle();
    }
    /**
     * getCommands
     *
     * from CommandListInterface
     */
    public void parse(String text) {
        myCommand.parse(text);
    }
    /**
     * setLanguage
     *
     * from CommandListInterface
     */
    public void setLanguage (String language) {
        myCommand.setLanguage(language);
    }
    /**
     * getLanguage
     *
     * from CommandListInterface
     */
    public String getLanguage() {
        return myCommand.getLanguage();
    }
    /**
     * setMessage
     *
     * from CommandListInterface
     */
    public void setMessage (String message) {
        myCommand.setMessage(message);
    }
}
