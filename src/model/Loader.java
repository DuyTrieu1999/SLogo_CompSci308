package model;

import commands.CommandInitializer;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class for loader
 * @author Allen Qiu
 */

public class Loader {
    private File file;
    private VariableMap variables;
    private CommandInitializer commands;

    /**
     * Constructe the loader
     * @param variableMap the variable map
     * @param commandInitializer the command initializer
     * @param loadFrom the file to load from
     */
    public Loader(VariableMap variableMap, CommandInitializer commandInitializer, File loadFrom){
        file = loadFrom;
        variables = variableMap;
        commands = commandInitializer;
    }

    /**
     * Load the file, if failed print error message.
     */
    public void load(){
        CommandParser parser = new CommandParser(variables, commands, new Turtle(0, 0, Color.BLACK, 0));
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                parser.parse(scanner.nextLine());
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
