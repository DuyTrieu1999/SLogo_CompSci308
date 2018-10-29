package commands;

import java.util.*;

public class TreeNode extends Node {

    private TreeNode parent;

    private String CommandName;
    private List<Node> children = new ArrayList<>();

    public TreeNode(TreeNode p, List<String> myList){
        parent = p;
        CommandName = myList.get(0);
    }

    public String getCommandName(){
        return CommandName;
    }


    public boolean fulfilled(CommandInitializer commandInitializer){
        //TODO
        //create the mapping of commands to commandnodes
        int numParameters = commandInitializer.getCommandNode(CommandName).getNumParameters();
        return numParameters==children.size();
    }

    public TreeNode getParent(){
        return parent;
    }

    public List<Node> getChildren(){
        return children;
    }

    public void addChild(Node n){
        children.add(n);
    }
}
