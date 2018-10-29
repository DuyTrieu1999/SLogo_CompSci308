package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

/**
 * A specific class for Pi.
 * @author Allen Qiu
 */


public class Pi extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){return Math.PI;
    }

    public int getNumParameters(){
        return numParameters;
    }
}
