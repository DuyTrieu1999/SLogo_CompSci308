package model;

import java.util.*;

/**
 * @Author Yunhao Qing
 */

public class CommandList implements CommandListInterface{
    private List<String> commands;
    private CommandParser myParser;

    public CommandList() {
        myParser = new CommandParser(getCommand());
        commands = new ArrayList<>();
    }

    public List<String> getCommands(){
        return commands;
    }

    public String getCommand () {
        return commands.get(commands.size()-1);
    }

    public void setLanguage (String language) {
        myParser.setLanguage(language);
    }

    public String getLanguage() {
        return myParser.getLanguage();
    }

    public void setMessage (String message) {

    }


}

