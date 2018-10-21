package commands;

import model.Turtle;

import java.util.Scanner;

public class Sum extends CommandNode {
    public int numParameters = 2;

    @Override
    public double run(Scanner args, Turtle turtle){
        double x = Double.parseDouble(args.next());
        double y = Double.parseDouble(args.next());
        return x+y;
    }

}
