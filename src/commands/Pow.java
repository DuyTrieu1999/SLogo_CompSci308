package commands;

import model.Turtle;

import java.util.Scanner;

public class Pow extends CommandNode {
    public int numParameters = 2;

    @Override
    public double run(Scanner args, Turtle turtle){
        double base = Double.parseDouble(args.next());
        double power = Double.parseDouble(args.next());
        return Math.pow(base, power);
    }

}
