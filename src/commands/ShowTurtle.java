package commands;

import model.Turtle;

import java.util.List;

public class ShowTurtle extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle){
        turtle.setVisibility(true);
        return 1;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
