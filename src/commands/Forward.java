package commands;

import model.Turtle;

import java.util.Scanner;

public class Forward extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(Scanner args, Turtle turtle){
        double distance = Double.parseDouble(args.next());
        turtle.move(distance);
        return distance;
    }

}
