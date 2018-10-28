package commands;

import javafx.scene.paint.Color;
import model.Turtle;
import model.VariableMap;

import java.util.List;
import java.util.ResourceBundle;

public class SetPenColor extends CommandNode {
    public int numParameters = 1;
    private ResourceBundle colors = ResourceBundle.getBundle("text/view");

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        turtle.setPenColor(Color.valueOf(colors.getString(parameters.get(0))));
        return Double.parseDouble(parameters.get(0));
    }

    public int getNumParameters(){
        return numParameters;
    }

}
