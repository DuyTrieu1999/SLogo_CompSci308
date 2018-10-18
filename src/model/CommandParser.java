package model;

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

    }
}
