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
    private ResourceBundle colors = ResourceBundle.getBundle("text/view");

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        for(int i=0; i<Integer.parseInt(colors.getString("NumColors")); i++){
            //System.out.println("Comparing " + turtle.getPenColor().toString() + " to  " + Color.valueOf(colors.getString(Integer.toString(i))).toString());
            if(turtle.getPenColor().equals(Color.valueOf(colors.getString(Integer.toString(i))))){
                //this is it
                return i;
            }
        }
        return 0;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
