package commands;

import model.CommandParser;
import model.Turtle;
import model.VariableMap;

import java.util.List;

public class DoTimes extends CommandNode {
    public int numParameters = 2;
    private double output = 0;

    @Override
    public double run(List<String> parameters, Turtle turtle, VariableMap varMap){
        String[] doTimesParameters = parameters.get(0).split("\\s+");
        String doTimesVar = doTimesParameters[0];
        double numTimes = Double.parseDouble(doTimesParameters[1]);
        for(int i=1;i<=numTimes;i++){
            varMap.addVariable(doTimesVar, i);
            CommandParser parser = new CommandParser();
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
