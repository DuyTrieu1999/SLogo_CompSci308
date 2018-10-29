package commands;

import model.CommandParser;
import model.Turtle;
import model.VariableMap;

import java.util.List;

/**
 * A specific class for IfElse.
 * @author Allen Qiu
 */


public class IfElse extends CommandNode {
    public int numParameters = 3;
    private double output = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        int expression = (int)Double.parseDouble(parameters.get(0));
        CommandParser parser = new CommandParser(varMap, commands, turtle);
        if(expression != 0){
            parser.parse(parameters.get(1));
            String[] lastLine = parser.getOutput().split("\\s+");
            output = Double.parseDouble(lastLine[lastLine.length-1]);
        }
        else {
            parser.parse(parameters.get(2));
            String[] lastLine = parser.getOutput().split("\\s+");
            output = Double.parseDouble(lastLine[lastLine.length-1]);
        }
        return output;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
