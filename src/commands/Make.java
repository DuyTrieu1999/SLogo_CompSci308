package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

public class Make extends CommandNode {
    public int numParameters = 2;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        String variable = parameters.get(0);
        double value = Double.parseDouble(parameters.get(1));
        varMap.addVariable(variable, value);
        return value;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
