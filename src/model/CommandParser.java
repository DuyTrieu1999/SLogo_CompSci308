package model;

import commands.CommandInitializer;
import commands.CommandNode;
import commands.CommandNodeTry;
import commands.Node;
import javafx.scene.paint.Color;

import java.lang.reflect.Array;
import java.util.*;

public class CommandParser {
    private List<CommandNode> commandList;
    //make a variablemap
    private VariableMap varMap = new VariableMap();
    //make a turtle for testing purposes
    private Turtle t = new Turtle(0, 0, Color.WHITE);
    private ResourceBundle resources = ResourceBundle.getBundle("languages/English");
    //start the command initializer with the language
    private CommandInitializer commandInitializer = new CommandInitializer(resources);
    //create the mapping of commands to commandnodes
    private Map<String, CommandNode> commandNodeMap = commandInitializer.createCommandMap();

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
            }
            list.add(temp);
            count++;

        }

        for(List<String> line:list){
            parseLine(line);
            System.out.println();
        }
        //System.out.println("Reached the end!");

        /*
        //make a variablemap
        VariableMap varMap = new VariableMap();
        //make a turtle for testing purposes
        Turtle t = new Turtle(0, 0, Color.WHITE);
        t.setOrientation(90);
        //start the command initializer with the language
        CommandInitializer commandInitializer = new CommandInitializer(ResourceBundle.getBundle("languages/English"));
        //create the mapping of commands to commandnodes
        Map<String, CommandNode> commandNodeMap = commandInitializer.createCommandMap(t);
        for(List<String> thisLine:list){
            //while the list is not all numbers, keep looping
            while(!checkAllNumbers(thisLine)){
                //loop through the elements one by one
                for(int j=0;j<thisLine.size();j++){
                    //default to this is a number
                    boolean isNumber = true;
                    try{
                        Double.parseDouble(thisLine.get(j));
                    }
                    catch(NumberFormatException e){
                        //if it detects it is not a number, it will return false
                        isNumber = false;
                    }

                    //if not a number
                    if(!isNumber) {
                        //create the associated command
                        CommandNode thisCommandNode = commandNodeMap.get(thisLine.get(j));
                        //get the number of parameters for this command
                        int numParameters = thisCommandNode.getNumParameters();
                        //initialize to command can be parsed
                        boolean canParseCommand = true;
                        //create a list of parameters for later use
                        List<String> parameters = new ArrayList<>();
                        for(int i=1; i<numParameters+1; i++){
                            //check every parameter ahead for numparameters and see if they are all numbers
                            try{
                                Double.parseDouble(thisLine.get(i+j));
                                //add the parameter for later use
                                parameters.add(thisLine.get(i+j));
                            }
                            catch(NumberFormatException e){
                                //if there are not all numbers, break
                                canParseCommand = false;
                                break;
                            }
                        }
                        //if we can parse the command
                        if(canParseCommand){
                            //get the return value from the commandnode
                            double returnValue = thisCommandNode.run(parameters, t, varMap);
                            //replace the current item in the list with the return value (this will be the command)
                            thisLine.set(j, Double.toString(returnValue));
                            //delete the parameters
                            for(int k=0;k<numParameters;k++){
                                thisLine.remove(j+1);
                            }
                            //restart from the beginning
                            break;
                        }
                    }
                }
            }
            for(String s:thisLine){
                System.out.print(s + " ");
            }
            System.out.println();
        }
        */
    }


    private void parseLine(List<String> thisLine){

        ArrayList<CommandNodeTry> rootNodes = new ArrayList<>();
        //any parent must be a command
        CommandNodeTry parent = null;
        for(String s:thisLine){
            //System.out.println("Currently parsing " + s);
            //for each space separated value
            if(isCommand(s)){
                //System.out.println("It's a command!");
                //command
                List<String> thisValue = new ArrayList<>();
                thisValue.add(s);
                CommandNodeTry thisCommandNode = new CommandNodeTry(parent, thisValue);
                if(parent == null){
                    //this is the root node
                    rootNodes.add(thisCommandNode);
                    //System.out.println("Parent is null so this is the root node!");
                }
                else {
                    parent.addChild(thisCommandNode);
                    //System.out.println("Adding this as a child of " + parent.getCommandName());
                }
                //if not fulfilled, this is the new parent
                //System.out.println("Setting parent to " + thisCommandNode.getCommandName());
                parent = thisCommandNode;
            }
            else {
                if(isNumeric(s)){
                    //System.out.println("It's a constant!");
                    List<String> thisValue = new ArrayList<>();
                    thisValue.add(s);
                    Node thisNode = new Node(parent, thisValue);
                    //the parent of a number must be a command
                    //System.out.println("The current parent is " + parent.getCommandName());
                    parent.addChild(thisNode);
                }
                else if(isList(s)){
                    //System.out.println("It's a list!");
                    //is a list
                    //a list should be passed in simply as a string minus the brackets, separated by spaces
                    //todo
                    List<String> thisValue = new ArrayList<>();
                    thisValue.addAll(Arrays.asList(s.split("\\s+")));
                    Node thisNode = new Node(parent, thisValue);
                    //the parent of a list must be a command
                    parent.addChild(thisNode);
                }
                else {
                    //variable
                    //only time it is not defined is if the preceding command is make
                    if(parent.getCommandName().compareToIgnoreCase(resources.getString("MakeVariable").split("\\|")[0]) == 0
                    || parent.getCommandName().compareToIgnoreCase(resources.getString("MakeVariable").split("\\|")[1]) == 0){
                        //this is a make command so simply add it as a child
                        List<String> thisValue = new ArrayList<>();
                        thisValue.add(s);
                        Node thisNode = new Node(parent, thisValue);
                        //the parent of a number must be a command
                        //System.out.println("The current parent is " + parent.getCommandName());
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
                            //System.out.println("The current parent is " + parent.getCommandName());
                            parent.addChild(thisNode);
                        }
                        else {
                            //error
                            System.out.println("Invalid variable!");
                        }
                    }
                }

                //check if this node fulfills the parent
                if(parent != null){
                    while(parent != null && parent.fulfilled()){
                        //System.out.println(parent.getCommandName() + " is now fulfilled!");
                        //simplify expression
                        //go up one level and evaluate parent
                        //change parent from CommandNode to Node and set value
                        //since parents must be commands, we know the parent is a command
                        CommandNode parentCommandNode = commandNodeMap.get(parent.getCommandName());
                        //merge the lists of all child nodes into one list
                        double returnValue = parentCommandNode.run(mergeParameters(parent), t, varMap);
                        CommandNodeTry parentOfParent = parent.getParent();
                        if(parentOfParent != null){
                            //System.out.println("Grand parent is " + parentOfParent.getCommandName());
                            parentOfParent.getChildren().remove(parent);
                            List<String> returnValueList = new ArrayList<>();
                            returnValueList.add(Double.toString(returnValue));
                            parentOfParent.getChildren().add(new Node(parentOfParent, returnValueList));
                        }
                        else {
                            System.out.print(returnValue + " ");
                        }
                        parent = parentOfParent;
                        /*
                        if(parent == null){
                            System.out.println("The new parent is null");
                        }
                        else {
                            System.out.println("The new parent is " + parent.getCommandName());
                        }
                        */
                    }
                }
            }
        }
    }

    public List<String> mergeParameters(CommandNodeTry parent){
        //todo
        List<String> mergedParameters = new ArrayList<>();
        for(Node n:parent.getChildren()){
            mergedParameters.addAll(n.getParameters());
        }
        return mergedParameters;
    }


    public boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    public boolean isCommand(String s){
        //todo
        return commandNodeMap.containsKey(s);
    }

    public boolean isList(String s){
        //todo
        if(s.split("\\s+").length > 1){
            return true;
        }
        return false;
    }

    private boolean checkAllNumbers(List<String> thisList){
        for(String s:thisList){
            try{
                Double.parseDouble(s);
            }
            catch(NumberFormatException e){
                return false;
            }
        }
        return true;
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
