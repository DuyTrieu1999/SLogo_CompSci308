package commands;

import java.util.*;

/**
 * A specific class for Node.
 * @author Allen Qiu
 */


public class Node {
    private String type;
    private TreeNode parent;
    private List<String> list;

    public Node(){
    }

    public Node(TreeNode p, List<String> l){
        parent = p;
        list = l;
    }


    public List<String> getParameters(){
        return list;
    }
}
