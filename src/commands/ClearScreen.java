package commands;

import model.Turtle;

import java.util.List;

public class ClearScreen extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle){
        turtle.clearLines();
        double oldX = turtle.getX();
        double oldY = turtle.getY();
        turtle.moveTo(0, 0);
        return Math.sqrt(Math.pow((oldY), 2)+Math.pow(oldX, 2));
    }

    public int getNumParameters(){
        return numParameters;
    }

}
