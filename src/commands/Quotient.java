package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

/**
 * A specific class for Quotient.
 * @author Allen Qiu
 */


public class Quotient extends CommandNode {
    public int numParameters = 2;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        double x = Double.parseDouble(parameters.get(0));
        double y = Double.parseDouble(parameters.get(1));
        return x/y;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
