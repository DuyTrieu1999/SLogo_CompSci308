package commands;

import javafx.scene.paint.Color;
import model.Turtle;
import model.VariableMap;

import java.util.HashMap;
import java.util.List;

public class PenColor extends CommandNode {
    public int numParameters = 1;
    private HashMap<String, Color> colorMap = new HashMap<>();

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap){
        turtle.setPenColor(colorMap.get(parameters.get(0)));
        return Double.parseDouble(parameters.get(0));
    }

    public int getNumParameters(){
        return numParameters;
    }

}
