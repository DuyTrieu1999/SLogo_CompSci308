package commands;

import model.Turtle;

import java.util.List;

public class Right extends CommandNode {
    public int numParameters = 1;

    public double run(List<String> parameters, Turtle turtle){
        double degrees = Double.parseDouble(parameters.get(0));
        turtle.turn(degrees*-1);
        return degrees;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
