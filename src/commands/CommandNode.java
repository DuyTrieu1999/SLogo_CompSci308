package commands;

import java.util.*;

public class CommandNode {

    private int numChildren;
    private int numParameters;
    private List<CommandNode> children;

    public CommandNode(){
        numChildren = 0;
        children = new ArrayList<>();
    }
}
