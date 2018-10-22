package commands;

import model.Turtle;
import javafx.scene.paint.Color;

import java.lang.reflect.Array;
import java.util.*;

public class newParserTry {
    public newParserTry(String str){
        List<List<String>> list = parseToList(str);
        Turtle t = new Turtle(0, 0, Color.WHITE);
        t.setOrientation(90);
        CommandInitializer commandInitializer = new CommandInitializer(ResourceBundle.getBundle("languages/English"));
        Map<String, CommandNode> commandNodeMap = commandInitializer.createCommandMap();
        for(List<String> thisLine:list)
            parseLine(thisLine, commandNodeMap, t);
    }

    private void parseLine(List<String> l,Map<String, CommandNode> commandNodeMap, Turtle t){
        int count = 0;
        //while there are commands left
        while (count < l.size()) {
            //should always be a command
            if (isCommand(l.get(count))){
                //create a new arraylist containing this node (which should be the root node)
                List<String> lis = new ArrayList<String>();
                lis.add(l.get(count));
                CommandNodeTry rootNode = new CommandNodeTry(null, lis);
                //create the pointer which points to this node
                CommandNodeTry pointer = rootNode;

                //while pointer is not fulfilled or the pointer is not the rootnode
                while (!(pointer.fulfilled() && pointer == rootNode)) {
                    if (pointer.fulfilled()) {
                        //evaluate each children if needed
                        //evaluate pointer
                        int a;
                        //TODO
                        if (pointer.isRootNode()){
                            count++;
                            break;
                        }
                    } else {
                        count++;
                        if (isNumeric(l.get(count))) {
                            List<String> temp = new ArrayList<>();
                            temp.add(l.get(count));
                            pointer.addChild(new Node(pointer, temp));
                        }
                        if (isCommand(l.get(count))) {
                            List<String> temp = new ArrayList<>();
                            temp.add(l.get(count));
                            CommandNodeTry myNode = new CommandNodeTry(pointer, lis);
                            pointer.addChild(myNode);
                            pointer = myNode;
                        }
                        if (isList(l.get(count))) {
                            List<String> balancedList = new ArrayList<String>();
                            balancedList.add(l.get(count));
                            while (!isBalance(balancedList)) {
                                count++;
                                balancedList.add(l.get(count));
                            }
                            pointer.addChild(new Node(pointer, balancedList));
                        }
                    }
                }
            }
            else{
                //error
                break;
            }
        }

    }

    private boolean isCommand(String str){
        //TODO
        return false;
    }

    private boolean isList(String str){
        return str.equals("[");
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
