package model;

import commands.CommandInitializer;
import commands.GenericCommand;
import model.VariableMap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Saver {
    VariableMap variables;
    CommandInitializer commands;
    File file;

    public Saver(VariableMap varMap, CommandInitializer commandInitializer, File toWriteTo){
        variables = varMap;
        commands = commandInitializer;
        file = toWriteTo;
    }

    public void save() {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("testtttt.txt"));
            for(Map.Entry<String, Double> entry:variables.getVariables().entrySet()){
                writer.write("make " + entry.getKey() + " " + entry.getValue());
                writer.newLine();
                System.out.print("Just wrote the variable" + entry.getKey());
            }
            for(Map.Entry<String, GenericCommand> entry:commands.getUserCommands().entrySet()){
                writer.write("to " + entry.getKey() + " [ " + entry.getValue().getVariables() + " ] [ " + entry.getValue().getCommand() + " ]");
                writer.newLine();
            }
            writer.close();
            System.out.print("Done saving!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<data media=\"SLogo\">\n" +
                "    <variables>" + mySimulationName + "<variables>\n" +
                "    <title>" + myTitle + "</title>\n" +
                "    <author>" + myAuthor + "</author>\n" +
                "    <shape>" + myShape + "</shape>\n" +
                "    <edgeType>" + myEdgeType + "</edgeType>\n" +
                "    <gridLines>" + getGridlines(myGridlines) + "</gridLines>\n" +
                "    <rows>" + myRows + "</rows>\n" +
                "    <cols>" + myColumns + "</cols>\n" +
                "    <configs>" + myGridUI.getCellStates() + "</configs>\n" +
                "    <neighbors>" + matrixToString(myNeighbors) + "</neighbors>\n" +
                "    <colors>" + String.join(",", myColors) + "</colors>\n" +
                "    <description>" + myDescription + "</description>\n" +
                "</data>";
         */
    }

}
