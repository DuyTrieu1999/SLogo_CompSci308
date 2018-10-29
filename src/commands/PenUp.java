package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

/**
 * A specific class for PenUp.
 * @author Allen Qiu
 */


public class PenUp extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        turtle.setPenVisibility(false);
        return 0;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
