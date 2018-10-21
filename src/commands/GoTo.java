package commands;

import model.Turtle;

import java.util.Scanner;

public class GoTo extends CommandNode {
    public int numParameters = 2;

    @Override
    public double run(Scanner args, Turtle turtle){
        double newX = Double.parseDouble(args.next());
        double newY = Double.parseDouble(args.next());
        double oldX = turtle.getX();
        double oldY = turtle.getY();
        turtle.moveTo(newX, newY);
        return Math.sqrt(Math.pow((newY - oldY), 2)+Math.pow((newX - oldX), 2));
    }

}
