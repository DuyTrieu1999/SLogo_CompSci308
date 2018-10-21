package model;

import commands.CommandInitializer;
import commands.CommandNode;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CommandParser {

    private CommandList myCommandList;
    private VariableMap myVarMap;
    private Turtle myTurtle;

    public CommandParser(Turtle t, CommandList cl, VariableMap vm){
        myCommandList = cl;
        myVarMap = vm;
        myTurtle = t;
    }

    public void parseWholeString(String allCommands){
        myCommandList.addCommand(allCommands);
        String[] commands = allCommands.split("\\r?\\n");
        for (String command : commands)
            parse(command);
    }

    public void parse(String oneCommand){
        CommandInitializer myCommands = new CommandInitializer(ResourceBundle.getBundle("languages/English"));
        Map<String, CommandNode> commandMap = myCommands.createCommandMap(myTurtle);
        Scanner commandScanner = new Scanner(oneCommand);
        commandMap.get(commandScanner.next());
    }
}
