package commands;

import java.util.*;

public class Node {
    private String type;
    //constant, variable, command, list of nodes;
    private TreeNode parent;
    private List<String> list;

    public Node(){

    }

    public Node(TreeNode p, List<String> l){
        parent = p;
        list = l;
    }

    public String getType(){
        return type;
    }

    public List<String> getParameters(){
        return list;
    }
}
