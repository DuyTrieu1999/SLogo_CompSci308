package commands;

import model.CommandParser;
import model.Turtle;
import model.VariableMap;

import java.util.List;

/**
 * A specific class for turtle ID.
 * @author Allen Qiu
 */


public class ID extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        return turtle.getID();
    }

    public int getNumParameters(){
        return numParameters;
    }

}
