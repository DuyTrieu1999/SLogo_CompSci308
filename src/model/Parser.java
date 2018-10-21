package model;

import commands.CommandNode;
import java.util.*;

public class Parser {
    private List<CommandNode> commandList;

    public Parser(String str){
        String[] lines=str.split("\\r?\\n");
        List<String> list = new ArrayList<>();
        for (String line : lines){
            if (!line.trim().isEmpty() && !(line.charAt(0)=='#')){
                String[] array = line.split("\\s+");
                list.addAll(Arrays.asList(array));
            }
        }
        int count = 0;
        while (count<list.size()){
//            CommandNode node;
//            //Somehow initilise the node with the string name;
//            List<String> parameters = new ArrayList<String>();
//            for (int i = count + 1; i <= count + node.getNumParameters();i++){
//                parameters.add(list.get(i));
//            }
//            node.setExtraParameters(parameters);
        }
    }


}
