package commands;

import model.Turtle;

import java.util.Scanner;

public class Right extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(Scanner args, Turtle turtle){
        double degrees = Double.parseDouble(args.next());
        turtle.turn(degrees*-1);
        return degrees;
    }

}
