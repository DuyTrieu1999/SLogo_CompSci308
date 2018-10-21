package commands;

import model.Turtle;

import java.util.Scanner;

public class Showing extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(Scanner args, Turtle turtle){
        if(turtle.getVisibility() == true){
            return 1;
        }
        return 0;
    }

}
