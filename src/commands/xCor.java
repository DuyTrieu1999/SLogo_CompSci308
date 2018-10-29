package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

/**
 * A specific class for xCor.
 * @author Allen Qiu
 */


public class xCor extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){return turtle.getX();
    }

    public int getNumParameters(){
        return numParameters;
    }

}
