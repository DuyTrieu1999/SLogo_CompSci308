package commands;

import javafx.scene.paint.Color;
import model.Turtle;
import model.VariableMap;

import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class SetBackground extends CommandNode {
    public int numParameters = 1;
    private HashMap<String, Integer> backgroundMap = new HashMap<>();
    private ResourceBundle colors = ResourceBundle.getBundle("text/view");

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        //turtle.setBackground(backgroundMap.get(parameters.get(0)));
        view.view_component.LogoScreen.setBackGroundColor(Color.valueOf(colors.getString(parameters.get(0))));
        return 0;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
