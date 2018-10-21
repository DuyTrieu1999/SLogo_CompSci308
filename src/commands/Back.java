package commands;

import model.Turtle;

import java.util.List;

public class Back extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(List<String> parameters, Turtle turtle){
        double distance = Double.parseDouble(parameters.get(0));
        turtle.move(distance*-1);
        return distance;
    }

    public int getNumParameters(){
        return numParameters;
    }
}
