package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

public class Right extends CommandNode {
    public int numParameters = 1;

    public double run(List<String> parameters, Turtle turtle, VariableMap varMap){
        double degrees = Double.parseDouble(parameters.get(0));
        turtle.turn(degrees*-1);
        return degrees;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
