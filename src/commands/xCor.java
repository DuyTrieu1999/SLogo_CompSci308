package commands;

import model.Turtle;

import java.util.Scanner;

public class xCor extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(Scanner args, Turtle turtle){
        return turtle.getX();
    }

}
