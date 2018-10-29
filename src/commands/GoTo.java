package commands;

import model.Turtle;
import model.VariableMap;

import java.util.List;
import java.util.Scanner;

/**
 * A specific class for GoTo.
 * @author Allen Qiu
 */


public class GoTo extends CommandNode {
    public int numParameters = 2;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        double newX = Double.parseDouble(parameters.get(0));
        double newY = Double.parseDouble(parameters.get(1));
        double oldX = turtle.getX();
        double oldY = turtle.getY();
        turtle.moveTo(newX, newY);
        return Math.sqrt(Math.pow((newY - oldY), 2)+Math.pow((newX - oldX), 2));
    }

    public int getNumParameters(){
        return numParameters;
    }

}
