package commands;

import model.CommandParser;
import model.Turtle;
import model.VariableMap;

import java.util.List;

public class Repeat extends CommandNode {
    public int numParameters = 2;
    private double output = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap, CommandInitializer commands){
        int numTimes = Integer.parseInt(parameters.get(0));
        for(int i=1;i<numTimes+1;i++){
            varMap.addVariable("repcount", i);
            //do all the commands
            CommandParser parser = new CommandParser(varMap, commands, turtle);
            parser.parse(parameters.get(1));
            if(i == numTimes){
                String[] lastLine = parser.getOutput().split("\\s+");
                output = Double.parseDouble(lastLine[lastLine.length-1]);
            }
        }
        return output;
    }

    public int getNumParameters(){
        return numParameters;
    }

}
