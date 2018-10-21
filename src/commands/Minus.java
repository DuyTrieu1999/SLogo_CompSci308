package commands;

import model.Turtle;

import java.util.Scanner;

public class Minus extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(Scanner args, Turtle turtle){
        double x = Double.parseDouble(args.next());
        return x*-1;
    }

}
