package commands;

import model.CommandParser;
import model.Turtle;
import model.VariableMap;

import java.util.List;

/**
 * A specific class for If.
 * @author Allen Qiu
 */


public class If extends CommandNode {
    public int numParameters = 2;
    private double output = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        int expression = (int)Double.parseDouble(parameters.get(0));
        if(expression != 0){
            CommandParser parser = new CommandParser(varMap, commands, turtle);
            parser.parse(parameters.get(1));
            String[] lastLine = parser.getOutput().split("\\s+");
            output = Double.parseDouble(lastLine[lastLine.length-1]);
        }
        return output;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
