package commands;

import java.util.*;

public class CommandNodeTry extends Node {

    private String type;
    private CommandNodeTry parent;
    private List<String> list;

    private String CommandName;
    private List<Node> children = new ArrayList<>();

    public CommandNodeTry(CommandNodeTry p, List<String> myList){
        parent = p;
        list = myList;
        type = "Command";
        CommandName = list.get(0);
    }

    public String getCommandName(){
        return CommandName;
    }


    public boolean isRootNode(){
        return parent == null;
    }

    public boolean fulfilled(CommandInitializer commandInitializer){
        //TODO
        //create the mapping of commands to commandnodes
        int numParameters = commandInitializer.getCommandNode(CommandName).getNumParameters();
        return numParameters==children.size();
    }

    public CommandNodeTry getParent(){
        return parent;
    }

    public List<Node> getChildren(){
        return children;
    }

    public void addChild(Node n){
        children.add(n);
    }
}
