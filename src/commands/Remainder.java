package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

public class Remainder extends CommandNode {
    public int numParameters = 2;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        double x = Double.parseDouble(parameters.get(0));
        double y = Double.parseDouble(parameters.get(1));
        return x%y;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
