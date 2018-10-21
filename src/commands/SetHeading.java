package commands;

import model.Turtle;

import java.util.Scanner;

public class SetHeading extends CommandNode {
    public int numParameters = 1;

    @Override
    public double run(Scanner args, Turtle turtle){
        double oldOrientation = turtle.getOrientation();
        double newOrientation = Double.parseDouble(args.next());
        turtle.setOrientation(newOrientation);
        return Math.abs(oldOrientation - newOrientation);
    }

}
