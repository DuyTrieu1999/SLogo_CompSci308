package model;


import commands.CommandInitializer;
import controller.Controller;

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

    public CommandList(Controller controller) {
        myController = controller;
        myParser = new CommandParser();
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

    public void setLanguage (ResourceBundle language) {
        myParser.setLanguage(language);
    }


}

