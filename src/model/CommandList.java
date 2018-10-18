package model;

import java.util.*;

/**
 * @Author Yunhao Qing
 */

public class CommandList implements CommandListInterface{
    private List<String> commands;

    public CommandList(){
        commands = new ArrayList<>();
    }

    public void addCommand(String str){
        commands.add(str);
    }

    public List<String> getCommands(){
        return commands;
    }

    public String getCommand () {
        return commands.get(commands.size()-1);
    }

    public void clearCommands(){
        commands = new ArrayList<>();
    }
}

