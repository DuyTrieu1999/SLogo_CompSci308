package commands;

import model.CommandParser;
import model.Turtle;
import model.VariableMap;

import java.util.List;

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
        //System.out.println("Successfully called GenericCommand!");
        //add variable to varmap
        for(int i=0;i<variables.length;i++){
            varMap.addVariable(variables[i], Double.parseDouble(parameters.get(i)));
            //System.out.println("Added the variable " + variables[i]);
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

    public String[] getVariables(){
        return variables;
    }

    public String getCommand(){
        return thisCommand;
    }

}
