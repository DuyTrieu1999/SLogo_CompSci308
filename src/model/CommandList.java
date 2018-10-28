package model;


import commands.CommandInitializer;
import controller.Controller;
import javafx.scene.paint.Color;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author Yunhao Qing
 * @Author Duy Trieu
 * @Author Brooke Keene
 */

public class CommandList implements CommandListInterface{
    private CommandParser myParser;
    private Controller myController;
    private Queue<String> myHistory;
    private VariableMap myVariables;

    public CommandList(Controller controller) {
        myController = controller;
        Turtle t = new Turtle(0, 0, Color.BLACK);
        CommandInitializer c = new CommandInitializer(ResourceBundle.getBundle("languages/English"));
        myVariables = new VariableMap();
        myParser = new CommandParser(myVariables, c, t);
        myHistory = new LinkedList<>();
    }

    public void addCommand (String newCommand) {
        myHistory.add(newCommand);
    }

    public Queue<String> getHistory() {
        return myHistory;
    }

    public void parse(String text) {
        myParser.parse(text);
    }

    public void setMessage (String message) {

    }

    public CommandParser getMyParser() {
        return myParser;
    }

    public void setLanguage (ResourceBundle language) {
        myParser.setLanguage(language);
    }

    public VariableMap getMyVariables() {
        return myVariables;
    }
}

