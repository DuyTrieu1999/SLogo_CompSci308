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
        getMessageConsumer = e -> myView.showMessage(e);
    }
    public SLogoView getView () {
        return myView;
    }

    /**
     * ModelAPI
     * return turtle
     */
    private Supplier<Turtle> turtleSupplier = () -> myCommand.getMyParser().getMyTurtle();
    public Turtle setTurtleSupplier () { return turtleSupplier.get(); }

    /**
     * ViewAPI
     * showMessage
     */
    private Consumer<String> getMessageConsumer;
    public void getMessageConsumer (String text) {
        getMessageConsumer.accept(text);
    }

    /**
     * ModelAPI
     * parse
     */
    private Consumer<String> parseConsumer = e -> myCommand.parse(e);
    public void setParseConsumer (String t) {
        parseConsumer.accept(t);
    }
    /**
     * ModelAPI
     * setLanguage
     */
    private Consumer<ResourceBundle> languageConsumer = e -> myCommand.setLanguage(e);
    public void setLanguageConsumer (ResourceBundle t) {
        languageConsumer.accept(t);
    }

    private Supplier<String> outputSupplier = () -> myCommand.getMyParser().getOutput();
    public String setOutputSupplier () { return outputSupplier.get(); }

    private Supplier<VariableMap> variableSupplier = () -> myCommand.getMyVariables();
    public VariableMap getVariableSupplier() {
        return variableSupplier.get();
    }

    private Supplier<CommandInitializer> initializerSupplier = () -> myCommand.getMyCommands();
    public CommandInitializer getInitializerSupplier() {
        return initializerSupplier.get();
    }
}
