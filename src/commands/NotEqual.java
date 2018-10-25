package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

public class NotEqual extends CommandNode {
    public int numParameters = 2;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        double num1 = Double.parseDouble(parameters.get(0));
        double num2 = Double.parseDouble(parameters.get(1));
        if(num1 != num2){
            return 1;
        }
        return 0;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
