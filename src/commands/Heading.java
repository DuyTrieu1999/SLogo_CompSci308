package commands;

import model.Turtle;

import java.util.List;

public class Heading extends CommandNode {
    public int numParameters = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle){
        return turtle.getOrientation();
    }

    public int getNumParameters(){
        return numParameters;
    }

}
