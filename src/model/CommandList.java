package model;

import java.util.*;

/**
 * @Author Yunhao Qing
 * @Author Duy Trieu
 */

public class CommandList implements CommandListInterface{
    private CommandParser myParser;

    public CommandList() {
        myParser = new CommandParser();
    }

    public void parse(String text) {
        myParser.parse(text);
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

