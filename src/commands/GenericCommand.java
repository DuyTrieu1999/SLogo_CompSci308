package commands;

import model.CommandParser;
import model.Turtle;
import model.VariableMap;

import java.util.List;


/**
 * A specific class for GenericCommand.
 * @author Allen Qiu
 */

public class GenericCommand extends CommandNode {
    public int numParameters;
    private double output = 0;
    private String[] variables;
    private String thisCommand;

    GenericCommand(String vars, String commands){
        variables = vars.split("\\s+");
        numParameters = variables.length;
        thisCommand = commands;
    }

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        for(int i=0;i<variables.length;i++){
            varMap.addVariable(variables[i], Double.parseDouble(parameters.get(i)));
        }
        CommandParser parser = new CommandParser(varMap, commands, turtle);
        parser.parse(thisCommand);
        String[] parserOutput = parser.getOutput().split("\\s+");
        output = Double.parseDouble(parserOutput[parserOutput.length-1]);
        return output;
    }

    public int getNumParameters(){
        return numParameters;
    }

    public String getVariables(){
        String output = "";
        for(String s:variables){
            output += s + " ";
        }
        output = output.substring(0, output.length()-1);
        return output;
    }

    public String getCommand(){
        return thisCommand;
    }

}
