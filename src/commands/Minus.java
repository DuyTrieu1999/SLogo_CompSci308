package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

public class Minus extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        double x = Double.parseDouble(parameters.get(0));
        return x*-1;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
