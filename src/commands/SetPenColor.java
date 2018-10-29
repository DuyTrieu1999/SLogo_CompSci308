package commands;

import javafx.scene.paint.Color;
import model.Turtle;
import model.VariableMap;

import java.util.List;
import java.util.ResourceBundle;

/**
 * A specific class for SetPenColor.
 * @author Allen Qiu
 */

public class SetPenColor extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        turtle.setPenColor(varMap.getPalette().get(Integer.parseInt(parameters.get(0))));
        return Double.parseDouble(parameters.get(0));
    }

    public int getNumParameters(){
        return numParameters;
    }

}
