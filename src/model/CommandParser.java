package model;

import commands.CommandInitializer;
import commands.CommandNode;
import javafx.scene.paint.Color;

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
            }
            list.add(temp);
            count++;

        }

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
                            double returnValue = thisCommandNode.run(parameters, t);
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
        }
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
