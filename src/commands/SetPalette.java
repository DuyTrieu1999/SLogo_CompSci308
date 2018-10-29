package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

/**
 * A specific class for SetPalette.
 * @author Allen Qiu
 */

public class SetPalette extends CommandNode {
    public int numParameters = 4;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        int index = Integer.parseInt(parameters.get(0));
        int r = Integer.parseInt(parameters.get(1));
        int g = Integer.parseInt(parameters.get(2));
        int b = Integer.parseInt(parameters.get(3));
        varMap.getPalette().addColor(index, r, g, b);
        return index;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
