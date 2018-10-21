package commands;

import model.Turtle;

import java.util.List;

public class Forward extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(List<String> parameters, Turtle turtle){
        double distance = Double.parseDouble(parameters.get(0));
        turtle.move(distance);
        return distance;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
