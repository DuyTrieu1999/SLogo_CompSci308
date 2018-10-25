package controller;

import model.CommandList;
import model.Turtle;
import view.SLogoView;
import view.turtleView.TurtleDriver;

import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Controller
 *
 * class that connects the front end and the back end
 *
 * @author duytrieu
 */
public class Controller {
    private SLogoView myView;
    private CommandList myCommand;

    public Controller (SLogoView view) {
        myView = view;
        myCommand = new CommandList(this);
    }
    public SLogoView getView () {
        return myView;
    }
    /**
     * ModelAPI
     * return turtle
     */
    Supplier<Turtle> turtleSupplier = () -> {return myCommand.getMyParser().getMyTurtle();};
    public Turtle setTurtleSupplier () { return turtleSupplier.get(); }
    /**
     * ViewAPI
     * clearConsole
     */
    Thread clearConsoleThread = new Thread(() -> myView.clearConsole());
    public void setClearConsoleRunnable () {
        myView.clearConsole();
    }
    /**
     * ViewAPI
     * clearDisplay
     */
    Thread clearDisplayThread = new Thread(() -> myView.clearDisplay());
    public void setClearDisplayRunnable () {
        myView.clearDisplay();
    }
    /**
     * ViewAPI
     * showMessage
     */
    Consumer<String> getMessageConsumer = e -> {myView.showMessage(e);};
    public void getMessageConsumer (String text) {
        getMessageConsumer.accept(text);
    }
    /**
     * ViewAPI
     * clearHistory
     */
    Thread clearHistoryThread = new Thread(() -> myView.clearHistory());
    public void setClearHistoryRunnable () {
        clearHistoryThread.run();
    }
    /**
     * ModelAPI
     * parse
     */
    Consumer<String> parseConsumer = e -> {myCommand.parse(e);};
    public void setParseConsumer (String t) {
        parseConsumer.accept(t);
    }
    /**
     * ModelAPI
     * setLanguage
     */
    Consumer<ResourceBundle> languageConsumer = e -> {myCommand.setLanguage(e);};
    public void setLanguageConsumer (ResourceBundle t) {
        languageConsumer.accept(t);
    }

    /**
     * setMessage
     *
     * from CommandListInterface
     */
    public void setMessage (String message) {
        myCommand.setMessage(message);
    }
    Consumer<String> setMessageConsumer = e -> {myCommand.setMessage(e);};
    public void setMessConsumer (String t) {
        setMessageConsumer.accept(t);
    }
}
