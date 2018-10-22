package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

public class PenDown extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap){
        turtle.setPenVisibility(true);
        return 1;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
