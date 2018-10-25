package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

public class SetPenSize extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap){
        turtle.setPenWidth(Double.parseDouble(parameters.get(0)));
        return Double.parseDouble(parameters.get(0));
    }

    public int getNumParameters(){
        return numParameters;
    }

}
