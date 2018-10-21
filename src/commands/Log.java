package commands;

import model.Turtle;

import java.util.List;

public class Log extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(List<String> parameters, Turtle turtle){
        double num = Double.parseDouble(parameters.get(0));
        return Math.log(num);
    }

    public int getNumParameters(){
        return numParameters;
    }

}
