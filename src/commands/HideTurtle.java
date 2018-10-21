package commands;

import model.Turtle;

import java.util.Scanner;

public class HideTurtle extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(Scanner args, Turtle turtle){
        turtle.setVisibility(false);
        return 0;
    }

}
