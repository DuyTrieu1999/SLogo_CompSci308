package model;

import commands.CommandInitializer;
import commands.CommandNode;
import javafx.scene.paint.Color;

import java.util.*;

public class CommandParser {
    public CommandParser(String str){
        List<List<String>> list = parseToList(str);
        Turtle t = new Turtle(0, 0, Color.WHITE);
        t.setOrientation(90);
        CommandInitializer commandInitializer = new CommandInitializer(ResourceBundle.getBundle("languages/English"));
        Map<String, CommandNode> commandNodeMap = commandInitializer.createCommandMap(t);
        for(List<String> thisLine:list)
            parseLine(thisLine, commandNodeMap, t);
    }

    private void parseLine(List<String> thisLine,Map<String, CommandNode> commandNodeMap, Turtle t){
        while(!allNumeric(thisLine)){
            for(int j = 0;j < thisLine.size(); j++){
                if(!isNumeric(thisLine.get(j))) {
                    CommandNode thisCommandNode = commandNodeMap.get(thisLine.get(j));
                    int numParameters = thisCommandNode.getNumParameters();
                    boolean parsable = true;
                    List<String> parameters = new ArrayList<>();
                    for(int i = 1; i<numParameters+1; i++){
                        if (isNumeric(thisLine.get(i+j)))
                            parameters.add(thisLine.get(i+j));
                        else{
                            parsable = false;
                            break;
                        }
                    }
                    if(parsable){
                        double returnValue = thisCommandNode.run(parameters, t);
                        thisLine.set(j, Double.toString(returnValue));
                        for(int k=0;k<numParameters;k++)
                            thisLine.remove(j+1);
                        break;
                    }
                }
            }
        }
    }

    private List<List<String>> parseToList(String str){
        List<String> lines = Arrays.asList(str.split("\\r?\\n"));
        List<String> cleanLines = new ArrayList<>();
        for (String line : lines){
            if (!line.trim().isEmpty() && !(line.charAt(0)=='#'))
                cleanLines.add(line);
        }
        lines  = cleanLines;
        List<List<String>> list = new ArrayList<>();
        int count = 0;
        while (count < lines.size()){
            String line = lines.get(count);
            List<String> temp = new ArrayList<>(Arrays.asList(line.split("\\s+")));
            while (!isBalance(temp)){
                count++;
                String newline = lines.get(count);
                temp.addAll(Arrays.asList(newline.split("\\s+")));
            }
            list.add(temp);
            count++;
        }
        return list;
    }

    private boolean allNumeric(List<String> thisList){
        for(String s:thisList)
            if (!isNumeric(s)) return false;
        return true;
    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    public boolean isBalance(List<String> strings){
        int count1 = 0,count2 = 0;
        for (String str : strings){
            if (str.equals("[")) count1++;
            if (str.equals("]")) count2++;
        }
        return count1 == count2;
    }
}
