package commands;

import javafx.scene.shape.Shape;
import model.Turtle;
import model.VariableMap;

import java.util.HashMap;
import java.util.List;

/**
 * A specific class for GetShape.
 * @author Allen Qiu
 */

public class GetShape extends CommandNode {
    public int numParameters = 0;
    private HashMap<String, Shape> shapeMap = new HashMap<>();

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        return turtle.getImageID();
    }

    public int getNumParameters(){
        return numParameters;
    }

}
