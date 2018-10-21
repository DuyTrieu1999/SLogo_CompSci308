package commands;

import model.Turtle;

import java.util.*;

public abstract class CommandNode {

    private int numChildren;
    public int numParameters;
    private List<CommandNode> children;

    public CommandNode(){
        numChildren = 0;
        children = new ArrayList<>();
    }

    abstract double run(Scanner args, Turtle turtle);
}
