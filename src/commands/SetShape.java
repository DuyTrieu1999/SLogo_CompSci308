package commands;

import javafx.scene.shape.Shape;
import model.Turtle;
import model.VariableMap;

import java.util.HashMap;
import java.util.List;

public class SetShape extends CommandNode {
    public int numParameters = 1;
    private HashMap<String, Shape> shapeMap = new HashMap<>();

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        //turtle.setShape(shapeMap.get(parameters.get(0)));
        return 0;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
