package model.xml;

import commands.CommandInitializer;
import model.VariableMap;

public class Saver {
    VariableMap variables;
    CommandInitializer commands;

    Saver(VariableMap varMap, CommandInitializer commandInitializer){
        variables = varMap;
        commands = commandInitializer;
    }

    public void save(){

    }

}
