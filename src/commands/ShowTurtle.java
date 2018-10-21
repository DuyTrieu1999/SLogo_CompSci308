package commands;

import model.Turtle;

import java.util.Scanner;

public class ShowTurtle extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(Scanner args, Turtle turtle){
        turtle.setVisibility(true);
        return 1;
    }

}
