package commands;

import javafx.scene.paint.Color;
import model.Turtle;
import model.VariableMap;

import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * A specific class for SetBackground.
 * @author Allen Qiu
 */


public class SetBackground extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        view.view_component.LogoScreen.setBackGroundColor(varMap.getPalette().get(Integer.parseInt(parameters.get(0))));
        return 0;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
