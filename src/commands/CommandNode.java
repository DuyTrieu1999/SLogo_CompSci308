package commands;

import model.Turtle;

import java.util.*;
import model.Turtle;

public abstract class CommandNode {

    private int numChildren;
    public int numParameters;
    private List<CommandNode> children;
    private List<String> extraParameters;
    private Turtle turtle;

    public CommandNode(Turtle t){
        numChildren = 0;
        children = new ArrayList<>();
        extraParameters = new ArrayList<>();
        turtle = t;
    }
    
    public int getNumParameters(){
        return numParameters;
    }

    public void setExtraParameters(List<String> list){
        extraParameters = list;
    }

    abstract double run(Scanner args, Turtle turtle);
}
