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


    /**
     * Constructor
     * @param vars variableMap
     * @param command commandInitializer
     * @param turt turtle
     */
    public CommandParser(VariableMap vars, CommandInitializer command, Turtle turt){
        varMap = vars;
        commandInitializer = command;
        t = turt;
    }

    /**
     * @return t my turtle
     */
    public Turtle getMyTurtle () {
        return t;
    }

    /**
     * Pass the string into parseToList
     * @param str the string to be parsed
     */
    public void parse (String str) {
        output = "";
        parseToList(str);
    }

    /**
     * Set up the language.
     * @param language a specific language
     */
    public void setLanguage(ResourceBundle language) {
        commandInitializer = new CommandInitializer(language);
    }

    /**
     * This method check whether a string is a number
     * @param str the string to be checked
     * @return boolean value
     */
    private static boolean isNumeric(String str) {
        return str.matches("-?[0-9]+\\.?[0-9]*");
    }

    /**
     * This method check whether a string is a possible variable.
     * @param str the string to be checked
     * @return boolean value
     */
    private static boolean isPossibleVariable(String str){
        return str.matches(":[a-zA-Z_]+");
    }

    /**
     * This method check whether a string is a possible command.
     * @param str the string to be checked
     * @return boolean value
     */

    private static boolean isPossibleCommand(String str){
        return str.matches("[a-zA-Z_]+(\\?)?");
    }

    /**
     * Parse the input string and do a few types of error checking.
     * @param str the input string
     * @return a list of nicely-formatted string
     */
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

    /**
     * Parse the string and execute actions.
     * @param str the input string
     */
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


    /**
     * Return the error message.
     * @return error message
     */
    public String returnError(){
        return errorMessage;
    }

    /**
     * return the calculated output
     * @return the calculated output
     */
    public String getOutput(){
        //System.out.println(output);
        return output;
    }


    /**
     * Parse the list of string
     * @param thisLine list of string
     * @return the string after this round of parsing
     */
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

    /**
     * Add a node to the parent node.
     * @param parent parent node
     * @param s child
     */
    private void addNode(TreeNode parent, String s) {
        List<String> thisValue = new ArrayList<>();
        thisValue.add(s);
        Node thisNode = new Node(parent, thisValue);
        assert parent != null;
        parent.addChild(thisNode);
    }

    /**
     * When condition fulfiled merge the parameters.
     * @param parent the treenode
     * @return the list after the merging
     */
    private List<String> mergeParameters(TreeNode parent){
        List<String> mergedParameters = new ArrayList<>();
        for(Node n:parent.getChildren()){
            mergedParameters.addAll(n.getParameters());
        }
        return mergedParameters;
    }


    /**
     * This method check whether a string is a command
     * @param str the string to be checked
     * @return boolean value
     */
    private boolean isCommand(String str){
        return commandInitializer.containsKey(str);
    }

    /**
     * This method check whether a string is a list
     * @param str the string to be checked
     * @return boolean value
     */
    private boolean isList(String str){
        return str.split("\\s+").length > 1;
    }

    /**
     * This method check whether the "[" and "]" matches in the list
     * @param strings a list of strings
     * @return boolean value
     */
    private boolean isBalance(List<String> strings){
        int count1 = 0,count2 = 0;
        for (String str : strings){
            if (str.equals("[")) count1++;
            if (str.equals("]")) count2++;
        }
        return count1 == count2;
    }
}