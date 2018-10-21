package model;

import commands.Command;
import commands.CommandInitializer;
import model.CommandList;
import model.Turtle;
import model.VariableMap;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CommandParser {

    private CommandList myCommandList;
    private VariableMap myVarMap;

    public CommandParser(Turtle t, CommandList cl, VariableMap vm){
        myCommandList = cl;
        myVarMap = vm;
        //myTurtle = t;
    }

    public void parseWholeString(String allCommands){
        myCommandList.addCommand(allCommands);
        String[] commands = allCommands.split("\\r?\\n");
        for (String command : commands)
            parse(command);
    }

    public static void parse(String oneCommand){
        CommandInitializer myCommands = new CommandInitializer(ResourceBundle.getBundle("languages/English"));
        Map<String, Command> commandMap = myCommands.createCommandMap();
        Scanner commandScanner = new Scanner(oneCommand);
        commandMap.get(commandScanner.next()).run(commandScanner);
    }
}

