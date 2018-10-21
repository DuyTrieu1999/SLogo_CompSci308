package commands;

import model.Turtle;

import java.util.Scanner;

public class Not extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(Scanner args, Turtle turtle){
        double num = Double.parseDouble(args.next());
        if(num == 0){
            return 1;
        }
        return 0;
    }

}
