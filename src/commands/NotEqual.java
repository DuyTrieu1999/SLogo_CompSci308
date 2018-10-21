package commands;

import model.Turtle;

import java.util.Scanner;

public class NotEqual extends CommandNode {
    public int numParameters = 2;

    @Override
    public double run(Scanner args, Turtle turtle){
        double num1 = Double.parseDouble(args.next());
        double num2 = Double.parseDouble(args.next());
        if(num1 != num2){
            return 1;
        }
        return 0;
    }

}
