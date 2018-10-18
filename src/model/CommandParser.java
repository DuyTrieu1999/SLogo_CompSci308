package model;

import commands.Command;

import java.util.Map;
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

    public static void parse(String oneCommand){
        Map<String, Command> commandMap = commands.CommandInitializer.createCommandMap();
        Scanner commandScanner = new Scanner(oneCommand);
        commandMap.get(commandScanner.next()).run(commandScanner);
    }
}
