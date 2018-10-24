package commands;

import model.Turtle;
import model.VariableMap;

import java.util.HashMap;
import java.util.List;

public class SetBackground extends CommandNode {
    public int numParameters = 1;
    private HashMap<String, Integer> backgroundMap = new HashMap<>();

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap){
        //turtle.setBackground(backgroundMap.get(parameters.get(0)));
        return 0;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
