package controller;

import commands.CommandInitializer;
import model.CommandList;
import model.Turtle;
import model.VariableMap;
import view.SLogoView;

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

    Supplier<SLogoView> SLogoSupplier = () -> { return myView;};
    public SLogoView setSLogoSupplier () { return SLogoSupplier.get(); }
    /**
     * ModelAPI
     * return turtle
     */
    Supplier<Turtle> turtleSupplier = () -> {return myCommand.getMyParser().getMyTurtle();};
    public Turtle setTurtleSupplier () { return turtleSupplier.get(); }
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
    Consumer<String> setMessageConsumer = e -> {myCommand.setMessage(e);};
    public void setMessConsumer (String t) {
        setMessageConsumer.accept(t);
    }

    Supplier<String> outputSupplier = () -> {return myCommand.getMyParser().getOutput();};
    public String setOutputSupplier () { return outputSupplier.get(); }

    Supplier<VariableMap> variableSupplier = () -> {return myCommand.getMyVariables();};
    public VariableMap getVariableSupplier() {
        return variableSupplier.get();
    }

    Supplier<CommandInitializer> initializerSupplier = () -> {return myCommand.getMyInitializer();};
    public CommandInitializer getInitializerSupplier() {
        return initializerSupplier.get();
    }
}
