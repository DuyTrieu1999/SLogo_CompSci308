package commands;

import model.Turtle;

import java.util.List;

public class Pow extends CommandNode {
    public int numParameters = 2;

    @Override
    public double run(List<String> parameters, Turtle turtle){
        double base = Double.parseDouble(parameters.get(0));
        double power = Double.parseDouble(parameters.get(1));
        return Math.pow(base, power);
    }

    public int getNumParameters(){
        return numParameters;
    }

}
