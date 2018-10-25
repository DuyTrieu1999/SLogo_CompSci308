package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;

public class Towards extends CommandNode {
    public int numParameters = 2;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap){
        double oldOrientation = turtle.getOrientation();
        double x = Double.parseDouble(parameters.get(0));
        double y = Double.parseDouble(parameters.get(1));
        double newOrientation = Math.toDegrees(Math.atan2(y, x));
        if(newOrientation < 0){
            newOrientation += 360;
        }
        turtle.setOrientation(newOrientation);
        return Math.abs(newOrientation - oldOrientation);
    }

    public int getNumParameters(){
        return numParameters;
    }

}
