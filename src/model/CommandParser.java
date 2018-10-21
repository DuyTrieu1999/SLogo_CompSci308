package model;

import commands.CommandNode;

import java.lang.reflect.Array;
import java.util.*;

public class CommandParser {
    private List<CommandNode> commandList;

    public CommandParser(String str){
        List<String> lines = Arrays.asList(str.split("\\r?\\n"));
        List<String> cleanLines = new ArrayList<>();
        for (String line : lines){
            if (!line.trim().isEmpty() && !(line.charAt(0)=='#'))
                cleanLines.add(line);
        }
        List<List<String>> list = new ArrayList<>();
        int count = 0;
        while (count < lines.size()){
            String line = lines.get(count);
            List<String> temp = new ArrayList<>();
            temp.addAll(Arrays.asList(line.split("\\s+")));
            while (!isBalance(temp)){
                count++;
                String newline = lines.get(count);
                temp.addAll(Arrays.asList(newline.split("\\s+")));
                count++;
                list.add(temp);
            }
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
