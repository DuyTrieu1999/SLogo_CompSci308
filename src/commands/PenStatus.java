package commands;

import model.Turtle;

import java.util.Scanner;

public class PenStatus extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(Scanner args, Turtle turtle){
        if(turtle.getPenVisibility() == true){
            return 1;
        }
        return 0;
    }

}
