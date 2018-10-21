package commands;

import model.Turtle;

import java.util.List;

public class Showing extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle){
        if(turtle.getVisibility() == true){
            return 1;
        }
        return 0;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
