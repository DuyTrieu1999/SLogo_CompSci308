package commands;

import model.Turtle;

import java.util.List;

public class SetHeading extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(List<String> parameters, Turtle turtle){
        double oldOrientation = turtle.getOrientation();
        double newOrientation = Double.parseDouble(parameters.get(0));
        turtle.setOrientation(newOrientation);
        return Math.abs(oldOrientation - newOrientation);
    }

    public int getNumParameters(){
        return numParameters;
    }

}