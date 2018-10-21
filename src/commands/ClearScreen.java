package commands;

import model.Turtle;

import java.util.Scanner;

public class ClearScreen extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(Scanner args, Turtle turtle){
        turtle.clearLines();
        double oldX = turtle.getX();
        double oldY = turtle.getY();
        turtle.moveTo(0, 0);
        return Math.sqrt(Math.pow((oldY), 2)+Math.pow(oldX, 2));
    }

}
