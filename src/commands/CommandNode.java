package commands;

import model.Turtle;

import java.util.*;
import model.VariableMap;

/**
 * A class for CommandNode, all other commands extend this class.
 * @author Allen Qiu
 * @author Yunhao Qing
 */
public abstract class CommandNode {


    public int numParameters;

    public CommandNode(){}

    public abstract int getNumParameters();

    public abstract double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands);
}
