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
        return Double.parseDouble(parserOutput[parserOutput.length - 1]);
    }

    public int getNumParameters(){
        return numParameters;
    }

    public String getVariables(){
        StringBuilder output = new StringBuilder();
        for(String s:variables){
            output.append(s).append(" ");
        }
        output = new StringBuilder(output.substring(0, output.length() - 1));
        return output.toString();
    }

    public String getCommand(){
        return thisCommand;
    }

}
