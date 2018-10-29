package commands;

import javafx.scene.paint.Color;
import model.Turtle;
import model.VariableMap;

import java.util.List;
import java.util.ResourceBundle;

/**
 * A specific class for PenColor.
 * @author Allen Qiu
 */

public class PenColor extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        for(int index:varMap.getPalette().keySet()){
            if(turtle.getPenColor().equals(varMap.getPalette().get(index))){
                //this is it
                return index;
            }
        }
        return 0;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
