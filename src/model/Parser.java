package model;

import commands.CommandNode;

import java.lang.reflect.Array;
import java.util.*;

public class Parser {
    private List<CommandNode> commandList;

    public Parser(String str){
        List<String> lines = Arrays.asList(str.split("\\r?\\n"));
        List<List<String>> list = new ArrayList<>();

        int count = 0;
        while (count < lines.size()){
            String line = lines.get(count);
            List<String> temp = new ArrayList<>();
            if (!line.trim().isEmpty() && !(line.charAt(0)=='#')){
                temp.addAll(Arrays.asList(line.split("\\s+")));
                while (!isBalance(temp)){
                    count++;
                    String newline = lines.get(count);
                    if (!newline.trim().isEmpty() && !(newline.charAt(0)=='#')){
                        temp.addAll(Arrays.asList(newline.split("\\s+")));
                    }
                }
                list.add(temp);
            }
        }


        count = 0;
        while (count<list.size()){
            CommandNode node;
            //Somehow initilise the node with the string name;
            List<String> parameters = new ArrayList<String>();
            for (int i = count + 1; i <= count + node.getNumParameters();i++){
                parameters.add(list.get(i));
            }
            node.setExtraParameters(parameters);
        }
    }

    public boolean isBalance(List<String> strings){
        int count1 = 0;
        int count2 = 0;
        for (String str : strings){
            if (str.equals("["))
                count1++;
            if (str.equals("]"))
                count2++;
        }
        return count1==count2;
    }
}
