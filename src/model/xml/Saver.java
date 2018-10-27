package model.xml;

import commands.CommandInitializer;
import commands.GenericCommand;
import model.VariableMap;

import java.util.Map;

public class Saver {
    VariableMap variables;
    CommandInitializer commands;

    Saver(VariableMap varMap, CommandInitializer commandInitializer){
        variables = varMap;
        commands = commandInitializer;
    }

    public void save(){
        String output = "Variables\n";
        for(Map.Entry<String, Double> entry:variables.getVariables().entrySet()){
            output += entry.getKey() + " " + entry.getValue() + "\n";
        }
        output += "Commands\n";
        for(Map.Entry<String, GenericCommand> entry:commands.getUserCommands().entrySet()){
            //output += entry.getKey() + " " + entry
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
