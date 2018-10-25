package commands;

import model.CommandParser;
import model.Turtle;
import model.VariableMap;

import java.util.List;

public class For extends CommandNode {
    public int numParameters = 2;
    private double output = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap){
        String[] forParameters = parameters.get(0).split("\\s+");
        String forVar = forParameters[0];
        int start = (int)Double.parseDouble(forParameters[1]);
        int end = (int)Double.parseDouble(forParameters[2]);
        int increment = Integer.parseInt(forParameters[3]);
        for(int i=start;i<=end;i+=increment){
            varMap.addVariable(forVar, i);
            CommandParser parser = new CommandParser();
            parser.parse(parameters.get(1));
            if(i == end){
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
