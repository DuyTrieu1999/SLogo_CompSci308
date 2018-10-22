package model;


import commands.CommandInitializer;
import controller.Controller;

import java.util.ResourceBundle;

/**
 * @Author Yunhao Qing
 * @Author Duy Trieu
 */

public class CommandList implements CommandListInterface{
    private CommandParser myParser;
    private Controller myController;

    public CommandList(Controller controller) {
        myController = controller;
        myParser = new CommandParser();
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

