package commands;

import model.Turtle;

import java.util.Scanner;

public class Sin extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(Scanner args, Turtle turtle){
        double degrees = Double.parseDouble(args.next());
        return Math.toDegrees(Math.sin(Math.toRadians(degrees)));
    }

}
