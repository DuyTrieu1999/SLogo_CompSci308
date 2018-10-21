package commands;

import model.Turtle;

import java.util.Scanner;

public class Towards extends CommandNode {

    @Override
    public double run(Scanner args, Turtle turtle){
        double oldOrientation = turtle.getOrientation();
        double x = Double.parseDouble(args.next());
        double y = Double.parseDouble(args.next());
        double newOrientation = Math.toDegrees(Math.atan2(y, x));
        if(newOrientation < 0){
            newOrientation += 360;
        }
        turtle.setOrientation(newOrientation);
        return Math.abs(newOrientation - oldOrientation);
    }

}
