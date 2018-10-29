package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

/**
 * A specific class for To.
 * @author Allen Qiu
 */


public class To extends CommandNode {
    public int numParameters = 3;
    private double output = 1;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        //add the variable to the map
        commands.addCommand(parameters.get(0).toLowerCase(), parameters.get(1), parameters.get(2));
        //System.out.println(parameters.get(0) + "\n" + parameters.get(1) + "\n" + parameters.get(2));
        //System.out.println("Added the command " + parameters.get(0));
        return output;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
