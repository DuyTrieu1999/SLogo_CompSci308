package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

/**
 * A specific class for Log.
 * @author Allen Qiu
 */


public class Log extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        double num = Double.parseDouble(parameters.get(0));
        return Math.log(num);
    }

    public int getNumParameters(){
        return numParameters;
    }

}
