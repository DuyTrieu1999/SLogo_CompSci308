package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

/**
 * A specific class for Showing.
 * @author Allen Qiu
 */

public class Showing extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        if(turtle.getVisibility() == true){
            return 1;
        }
        return 0;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
