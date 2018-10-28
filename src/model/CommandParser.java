package model;

import commands.CommandInitializer;
import commands.CommandNode;
import commands.CommandNodeTry;
import commands.Node;

import java.util.*;

public class CommandParser {
    private String language = "English";
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

    public Turtle getMyTurtle () { return t;}

    public void parse (String str) {
        parseToList(str);
    }

    public void setLanguage(ResourceBundle language) {
        commandInitializer = new CommandInitializer(language);
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?[0-9]+\\.?[0-9]*");
    }

    public static boolean isPossibleVariable(String str){
        return str.matches(":[a-zA-Z_]+");
    }

    public static boolean isPossibleCommand(String str){
        return str.matches("[a-zA-Z_]+(\\?)?");
    }


    private List<String> parseAndCheckList(String str){
        List<String> lines = Arrays.asList(str.split("\\r?\\n"));
        List<String> cleanLines = new ArrayList<>();
        for (String line : lines){
            if (!line.trim().isEmpty() && !(line.charAt(0)=='#')){
                cleanLines.add(line);
            }
        }
        List<String> partList = new ArrayList<>();
        for (String s : cleanLines){
            partList.addAll(Arrays.asList(s.split("\\s+")));
        }
        int count1 = 0, count2 = 0;
        for (int i = 0; i < partList.size();i++){
            String s = partList.get(i);
            if (!(isNumeric(s) || isPossibleCommand(s)|| isPossibleVariable(s) || s.equals("[") || s.equals("]"))){
                errorMessage = "Invalid input : Input contains index component at index" + i + "of the commands.";
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
        return cleanLines;
    }

    private List<List<String>> parseToList(String str){
        List<String> lines = parseAndCheckList(str);
        str = str.replace("\n", " ");
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

        for (int i = 0; i < list.size();i++){
            List<String> temp = list.get(i);
            List<String> sub = new ArrayList<>();
            count = 0;
            while (count < temp.size()){
                if (!temp.get(count).equals("[") && !temp.get(count).equals("]")){
                    sub.add(temp.get(count));
                    count++;
                }
                else if (temp.get(count).equals("[")){
                    List<String> record = new ArrayList<>();
                    String recordStr = "";
                    record.add("[");
                    count++;
                    while (!isBalance(record)){
                        recordStr += temp.get(count) + " ";
                        record.add(temp.get(count));
                        count++;
                    }
                    recordStr = recordStr.substring(0,recordStr.length()-3);
                    sub.add(recordStr);
                }
            }
            list.set(i,sub);
        }

        for(List<String> line:list){
            output = output + parseLine(line) + "\n";
        }
        return list;
    }

    public String returnError(){
        return errorMessage;
    }

    public String getOutput(){
        System.out.println(output);
        return output;
    }


    private String parseLine(List<String> thisLine){
        String output = "";
        ArrayList<CommandNodeTry> rootNodes = new ArrayList<>();
        //any parent must be a command
        CommandNodeTry parent = null;
        for(String s:thisLine){
            //for each space separated value
            if(isCommand(s)){
                //command
                //System.out.println(s + " is a command!");
                List<String> thisValue = new ArrayList<>();
                thisValue.add(s);
                CommandNodeTry thisCommandNode = new CommandNodeTry(parent, thisValue);
                if(parent == null){
                    //this is the root node
                    rootNodes.add(thisCommandNode);
                }
                else {
                    parent.addChild(thisCommandNode);
                }
                //if not fulfilled, this is the new parent
                parent = thisCommandNode;
            }
            else {
                if(isNumeric(s)){
                    //System.out.println(s + " is a number!");
                    List<String> thisValue = new ArrayList<>();
                    thisValue.add(s);
                    Node thisNode = new Node(parent, thisValue);
                    //the parent of a number must be a command
                    parent.addChild(thisNode);
                }
                else if(isList(s)){
                    //System.out.println(s + " is a list!");
                    //is a list
                    //a list should be passed in simply as a string minus the brackets, separated by spaces
                    //todo
                    List<String> thisValue = new ArrayList<>();
                    thisValue.add(s);
                    Node thisNode = new Node(parent, thisValue);
                    //the parent of a list must be a command
                    parent.addChild(thisNode);
                }
                else {
                    //System.out.println(s + " is a variable!");
                    //variable
                    //only time it is not defined is if the preceding command is make
                    if(parent.getCommandName().compareToIgnoreCase(resources.getString("MakeVariable").split("\\|")[0]) == 0
                            || parent.getCommandName().compareToIgnoreCase(resources.getString("MakeVariable").split("\\|")[1]) == 0 || parent.getCommandName().compareToIgnoreCase(resources.getString("MakeUserInstruction")) == 0){
                        //this is a make command so simply add it as a child
                        List<String> thisValue = new ArrayList<>();
                        thisValue.add(s);
                        Node thisNode = new Node(parent, thisValue);
                        //the parent of a number must be a command
                        parent.addChild(thisNode);
                    }
                    else {
                        //not a make command
                        if(varMap.contains(s)){
                            double variableValue = varMap.getVariable(s);
                            List<String> thisValue = new ArrayList<>();
                            thisValue.add(Double.toString(variableValue));
                            Node thisNode = new Node(parent, thisValue);
                            //the parent of a number must be a command
                            parent.addChild(thisNode);
                        }
                        else {

                        }
                    }
                }
            }
            //check if this node fulfills the parent
            if(parent != null){
                //System.out.println(parent.getCommandName());
                while(parent != null && parent.fulfilled(commandInitializer)){
                    //simplify expression
                    //go up one level and evaluate parent
                    //change parent from CommandNode to Node and set value
                    //since parents must be commands, we know the parent is a command
                    CommandNode parentCommandNode = commandInitializer.getCommandNode(parent.getCommandName());
                    //merge the lists of all child nodes into one list
                    double returnValue = parentCommandNode.run(mergeParameters(parent), t, varMap, commandInitializer);
                    CommandNodeTry parentOfParent = parent.getParent();
                    if(parentOfParent != null){
                        parentOfParent.getChildren().remove(parent);
                        List<String> returnValueList = new ArrayList<>();
                        returnValueList.add(Double.toString(returnValue));
                        parentOfParent.getChildren().add(new Node(parentOfParent, returnValueList));
                    }
                    else {
                        output = output + returnValue + " ";
                    }
                    parent = parentOfParent;
                }
            }
        }
        return output;
    }

    public List<String> mergeParameters(CommandNodeTry parent){
        //todo
        List<String> mergedParameters = new ArrayList<>();
        for(Node n:parent.getChildren()){
            mergedParameters.addAll(n.getParameters());
        }
        return mergedParameters;
    }


    public boolean isCommand(String s){
        return commandInitializer.containsKey(s);
    }

    public boolean isList(String s){
        return s.split("\\s+").length > 1;

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