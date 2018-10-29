package model;

import commands.CommandInitializer;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loader {
    File file;
    VariableMap variables;
    CommandInitializer commands;

    public Loader(File loadFrom, VariableMap variableMap, CommandInitializer commandInitializer){
        file = loadFrom;
        variables = variableMap;
        commands = commandInitializer;
    }

    public void load(){
        CommandParser parser = new CommandParser(variables, commands, new Turtle(0, 0, Color.WHITE, 0));
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
