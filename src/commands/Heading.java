package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

/**
 * A specific class for Heading.
 * @author Allen Qiu
 */


public class Heading extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        return turtle.getOrientation();
    }

    public int getNumParameters(){
        return numParameters;
    }

}
