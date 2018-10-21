package commands;

import model.Turtle;

import java.util.List;

public class PenDown extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle){
        turtle.setPenVisibility(true);
        return 1;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
