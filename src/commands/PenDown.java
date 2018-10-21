package commands;

import model.Turtle;

import java.util.Scanner;

public class PenDown extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(Scanner args, Turtle turtle){
        turtle.setPenVisibility(true);
        return 1;
    }

}
