package model;


import commands.CommandInitializer;
import controller.Controller;
import javafx.scene.paint.Color;

import java.util.ResourceBundle;

/**
 * @Author Yunhao Qing
 * @Author Duy Trieu
 */

public class CommandList implements CommandListInterface{
    private CommandParser myParser;
    private Controller myController;
    private Turtle turtle;

    public CommandList(Controller controller) {
        myController = controller;
        turtle = new Turtle(0, 0, Color.BLACK);
        CommandInitializer c = new CommandInitializer(ResourceBundle.getBundle("languages/English"));
        VariableMap v = new VariableMap();
        myParser = new CommandParser(v, c, turtle);
    }

    public void parse(String text) {
        myParser.parse(text);
    }

    public void setMessage (String message) {

    }

    public CommandParser getMyParser () { return this.myParser; }

    public Turtle getTurtle () { return turtle; }

    public void setLanguage (ResourceBundle language) {
        myParser.setLanguage(language);
    }


}

