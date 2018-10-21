package commands;

import model.Turtle;

import java.util.Scanner;

public class Log extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(Scanner args, Turtle turtle){
        double num = Double.parseDouble(args.next());
        return Math.log(num);
    }

}
