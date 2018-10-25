package commands;

import model.Turtle;

import java.util.*;
import model.Turtle;
import model.VariableMap;

public abstract class CommandNode {

    private int numChildren;
    public int numParameters;
    private List<CommandNode> children;
    private List<String> extraParameters;
    private Turtle turtle;

    public CommandNode(){

    }

    public CommandNode(Turtle t){
        numChildren = 0;
        children = new ArrayList<>();
        extraParameters = new ArrayList<>();
        turtle = t;
    }
    
    public abstract int getNumParameters();

    public void setExtraParameters(List<String> list){
        extraParameters = list;
    }

    public abstract double run(List<String> parameters, Turtle turtle, VariableMap varMap);
}
