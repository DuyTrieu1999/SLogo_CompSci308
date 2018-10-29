package model;

import commands.CommandInitializer;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Allen Qiu
 */

public class Loader {
    File file;
    VariableMap variables;
    CommandInitializer commands;

    public Loader(VariableMap variableMap, CommandInitializer commandInitializer, File loadFrom){
        file = loadFrom;
        variables = variableMap;
        commands = commandInitializer;
    }

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
