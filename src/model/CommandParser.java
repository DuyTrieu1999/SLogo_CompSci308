package model;

import commands.CommandInitializer;
import commands.CommandNode;
import commands.TreeNode;
import commands.Node;

import java.util.*;

/**
 * The CommandParser Class parse the commands and execute them.
 *
 * @author Yunhao Qing
 * @author Allen Qiu
 */

public class CommandParser {
    private String output = "";
    private VariableMap varMap;
    private ResourceBundle resources = ResourceBundle.getBundle("languages/English");
    private CommandInitializer commandInitializer;
    private Turtle t;
    private String errorMessage;

    public CommandParser(VariableMap vars, CommandInitializer command, Turtle turt){
        varMap = vars;
        commandInitializer = command;
        t = turt;
    }

    public Turtle getMyTurtle () {
        return t;
    }

    public void parse (String str) {
        output = "";
        parseToList(str);
    }

    public void setLanguage(ResourceBundle language) {
        commandInitializer = new CommandInitializer(language);
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?[0-9]+\\.?[0-9]*");
    }

    private static boolean isPossibleVariable(String str){
        return str.matches(":[a-zA-Z_]+");
    }

    private static boolean isPossibleCommand(String str){
        return str.matches("[a-zA-Z_]+(\\?)?");
    }


    private List<String> parseAndCheckList(String str){
        String[] lines = str.split("\\r?\\n");
        List<String> cleanLines = new ArrayList<>();
        for (String line : lines){
            if (!line.trim().isEmpty() && !(line.charAt(0)=='#')){
                cleanLines.add(line);
            }
        }
        List<String> partList = new ArrayList<>();
        for (String s : cleanLines){
            String[] parts = s.split("\\s+");
            for (String part : parts)
                if (!part.equals("")) partList.add(part);
        }
        int count1 = 0, count2 = 0;
        for (int i = 0; i < partList.size();i++){
            String s = partList.get(i);
            if (!(isNumeric(s) || isPossibleCommand(s)|| isPossibleVariable(s) || s.equals("[") || s.equals("]"))){
                errorMessage = "Invalid input : Input contains invalid component at index" + i + "of the commands.";
            }
            else if (s.equals("[")) count1++;
            else if (s.equals("]")) count2++;
            if (count2 > count1){
                errorMessage = "Invalid input : More ']' than '[' at index" + i + "of the commands.";
            }
        }
        if (count1 > count2){
            errorMessage = "Invalid input : More '[' than ']', brackets cannot match.";
        }
        return partList;
    }

    private void parseToList(String str){
        List<String> lines = parseAndCheckList(str);
        List<String> sub = new ArrayList<>();
        int count = 0;
        while (count < lines.size()){
            if (!lines.get(count).equals("[") && !lines.get(count).equals("]")){
                sub.add(lines.get(count));
                count++;
            }
            else if (lines.get(count).equals("[")){
                List<String> record = new ArrayList<>();
                StringBuilder recordStr = new StringBuilder();
                record.add("[");
                count++;
                while (!isBalance(record)){
                    recordStr.append(lines.get(count)).append(" ");
                    record.add(lines.get(count));
                    count++;
                }
                recordStr = new StringBuilder(recordStr.substring(0, recordStr.length() - 3));
                sub.add(recordStr.toString());
            }
        }
        output = output + parseLine(sub) + "\n";
    }


    String returnError(){
        return errorMessage;
    }

    public String getOutput(){
        //System.out.println(output);
        return output;
    }


    private String parseLine(List<String> thisLine){
        StringBuilder output = new StringBuilder();
        ArrayList<TreeNode> rootNodes = new ArrayList<>();
        TreeNode parent = null;
        for(String s:thisLine){
            if(isCommand(s)){
                List<String> thisValue = new ArrayList<>();
                thisValue.add(s);
                TreeNode thisCommandNode = new TreeNode(parent, thisValue);
                if(parent == null){
                    rootNodes.add(thisCommandNode);
                }
                else {
                    parent.addChild(thisCommandNode);
                }
                parent = thisCommandNode;
            }
            else if(isNumeric(s)){
                addNode(parent, s);
            }
            else if(isList(s)){
                addNode(parent, s);
            }
            else {
                assert parent != null;
                if(parent.getCommandName().compareToIgnoreCase(resources.getString("MakeVariable").split("\\|")[0]) == 0
                            || parent.getCommandName().compareToIgnoreCase(resources.getString("MakeVariable").split("\\|")[1]) == 0 || parent.getCommandName().compareToIgnoreCase(resources.getString("MakeUserInstruction")) == 0){
                    List<String> thisValue = new ArrayList<>();
                    thisValue.add(s);
                    Node thisNode = new Node(parent, thisValue);
                    parent.addChild(thisNode);
                }
                else if(varMap.contains(s)){
                    double variableValue = varMap.getVariable(s);
                    List<String> thisValue = new ArrayList<>();
                    thisValue.add(Double.toString(variableValue));
                    Node thisNode = new Node(parent, thisValue);
                    parent.addChild(thisNode);
                }
                else {
                    errorMessage = "Invalid input : " + s + "not a valid variable";
                }
            }
            while(parent != null && parent.fulfilled(commandInitializer)){
                CommandNode parentCommandNode = commandInitializer.getCommandNode(parent.getCommandName());
                double returnValue = parentCommandNode.run(mergeParameters(parent), t, varMap, commandInitializer);
                TreeNode parentOfParent = parent.getParent();
                if(parentOfParent != null){
                    parentOfParent.getChildren().remove(parent);
                    List<String> returnValueList = new ArrayList<>();
                    returnValueList.add(Double.toString(returnValue));
                    parentOfParent.getChildren().add(new Node(parentOfParent, returnValueList));
                }
                else {
                    output.append(returnValue).append(" ");
                }
                parent = parentOfParent;
            }
        }
        return output.toString();
    }

    private void addNode(TreeNode parent, String s) {
        List<String> thisValue = new ArrayList<>();
        thisValue.add(s);
        Node thisNode = new Node(parent, thisValue);
        assert parent != null;
        parent.addChild(thisNode);
    }

    private List<String> mergeParameters(TreeNode parent){
        List<String> mergedParameters = new ArrayList<>();
        for(Node n:parent.getChildren()){
            mergedParameters.addAll(n.getParameters());
        }
        return mergedParameters;
    }


    private boolean isCommand(String s){
        return commandInitializer.containsKey(s);
    }

    private boolean isList(String s){
        return s.split("\\s+").length > 1;
    }


    private boolean isBalance(List<String> strings){
        int count1 = 0,count2 = 0;
        for (String str : strings){
            if (str.equals("[")) count1++;
            if (str.equals("]")) count2++;
        }
        return count1 == count2;
    }
}