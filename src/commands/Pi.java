package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

public class Pi extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap){
        return Math.PI;
    }

    public int getNumParameters(){
        return numParameters;
    }
}
