package commands;

import model.Turtle;

import java.util.List;

public class Left extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(List<String> parameters, Turtle turtle){
        double degrees = Double.parseDouble(parameters.get(0));
        turtle.turn(degrees);
        return degrees;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
