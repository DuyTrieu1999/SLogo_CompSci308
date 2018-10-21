package commands;

import model.Turtle;

import java.util.Scanner;

public class PenUp extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(Scanner args, Turtle turtle){
        turtle.setPenVisibility(false);
        return 0;
    }

}
