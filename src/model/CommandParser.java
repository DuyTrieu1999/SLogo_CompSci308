import commands.CommandInitializer;
import commands.CommandNode;
import commands.CommandNodeTry;
import commands.Node;
import javafx.scene.paint.Color;
import model.Turtle;
import model.VariableMap;

import java.util.*;

public class CommandParser {
    // private List<CommandNode> commandList;
    private String language = "English";
    private String output = "";
    private List<CommandNode> commandList;
    //make a variablemap
    private VariableMap varMap;
    private ResourceBundle resources = ResourceBundle.getBundle("languages/English");
    //start the command initializer with the language
    private CommandInitializer commandInitializer;
    //private Map<Integer, Turtle> turtleMap = new HashMap<>();
    //private int currentTurtle = 0;
    private Turtle t;

    public CommandParser(VariableMap vars, CommandInitializer command, Turtle turt){
        varMap = vars;
        commandInitializer = command;
        t = turt;
    }

    public void parse (String str) {
        parseToList(str);
    }

    public void setLanguage(ResourceBundle language) {
        commandInitializer = new CommandInitializer(language);
    }

    private List<List<String>> parseToList(String str){
        //split by newline
        List<String> lines = Arrays.asList(str.split("\\r?\\n"));
        List<String> cleanLines = new ArrayList<>();
        //trim and ignore comments
        for (String line : lines){
            if (!line.trim().isEmpty() && !(line.charAt(0)=='#'))
                cleanLines.add(line);
        }
        //lines now contains the cleaned up lines
        lines  = cleanLines;
        List<List<String>> list = new ArrayList<>();
        int count = 0;
        //loop for every line parsed
        while (count < lines.size()){
            String line = lines.get(count);
            //create a temp arraylist that splits by space
            List<String> temp = new ArrayList<>(Arrays.asList(line.split("\\s+")));
            //System.out.println("Temp is of length " + temp.size());
            while(temp.contains("[")){
                for(int i=0;i<temp.size();i++){
                    if(temp.get(i).equals("[")){
                        //start of enclosed string at i
                        int beginList = i;
                        i++;
                        String thisList = "";
                        while(!temp.get(i).equals("]")){
                            thisList += temp.get(i) + " ";
                            i++;
                        }
                        thisList = thisList.substring(0, thisList.length()-1);
                        int endList = i;
                        temp.remove(endList);
                        temp.remove(beginList);
                        for(int j=0;j<(endList-beginList-1);j++){
                            temp.remove(beginList);
                        }
                        temp.add(beginList, thisList);
                        break;
                    }
                }
            }

            /*
            while (!isBalance(temp)){
                //if there is no open and end bracket on the same line
                count++;
                String newline = lines.get(count);
                temp.addAll(Arrays.asList(newline.split("\\s+")));
            }
            */
            list.add(temp);
            count++;

        }

        /*
        for(List<String> thisList:list){
            for(String s:thisList){
                System.out.print(s + " break ");
            }
            System.out.println();
        }
        */


        for(List<String> line:list){
            output = output + parseLine(line) + "\n";
        }


        return list;

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
        }
        */
    }

    public String getOutput(){
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
                    List<String> thisValue = new ArrayList<>();
                    thisValue.add(s);
                    Node thisNode = new Node(parent, thisValue);
                    //the parent of a number must be a command
                    parent.addChild(thisNode);
                }
                else if(isList(s)){
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
                            //error
                            System.out.println(s + " is an invalid variable!");
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
        //todo
        return commandInitializer.containsKey(s);
    }

    public boolean isList(String s){
        //todo
        if(s.split("\\s+").length > 1){
            return true;
        }
        return false;
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
