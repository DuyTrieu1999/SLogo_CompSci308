package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

public class Make extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap){
        String variable = parameters.get(0);
        double value = Double.parseDouble(parameters.get(1));

        return 0;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
