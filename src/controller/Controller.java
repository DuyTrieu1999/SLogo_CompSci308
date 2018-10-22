package controller;

import model.CommandList;
import model.CommandListInterface;
import view.SLogoView;
import view.SLogoViewAPI;
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



    Supplier<TurtleDriver> turtleDriverSupplier = () -> {return myView.getTurtle();};
    public TurtleDriver setTurtleSuplier () {
        return turtleDriverSupplier.get();
    }

    Consumer<String> parseConsumer = e -> {myCommand.parse(e);};
    public void setParseConsumer (String t) {
        parseConsumer.accept(t);
    }

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
}
