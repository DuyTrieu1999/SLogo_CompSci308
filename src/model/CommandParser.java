package model;

import commands.CommandNode;

import java.util.*;

public class CommandParser {
    private List<CommandNode> commandList;
    private String language = "English";

    public CommandParser(){

    }
    public String getLanguage () {
        return language;
    }

    public void parse (String string) {
        System.out.println(string);
    }

    public void setLanguage (String string) {
        language = string;
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
