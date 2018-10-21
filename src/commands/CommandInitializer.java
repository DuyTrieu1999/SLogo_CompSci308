package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CommandInitializer {

    private Map<String, Command> commandMap = new HashMap<>();
    private ResourceBundle resources;

    public CommandInitializer(ResourceBundle myResources){
        resources = myResources;
    }

    public Map<String, Command> createCommandMap(){

        commandMap.put(resources.getString("Forward").split("\\|")[0], new Forward());
        commandMap.put(resources.getString("Forward").split("\\|")[1], new Forward());
        commandMap.put(resources.getString("Backward").split("\\|")[0], new Back());
        commandMap.put(resources.getString("Backward").split("\\|")[1], new Back());
        commandMap.put(resources.getString("Left").split("\\|")[0], new Left());
        commandMap.put(resources.getString("Left").split("\\|")[1], new Left());
        commandMap.put(resources.getString("Right").split("\\|")[0], new Right());
        commandMap.put(resources.getString("Right").split("\\|")[1], new Right());
        commandMap.put(resources.getString("SetHeading").split("\\|")[0], new SetHeading());
        commandMap.put(resources.getString("SetHeading").split("\\|")[1], new SetHeading());
        commandMap.put(resources.getString("SetTowards"), new Towards());
        commandMap.put(resources.getString("SetPosition"), new GoTo());
        //commandMap.put("goto", new GoTo());
        commandMap.put(resources.getString("PenDown").split("\\|")[0], new PenDown());
        commandMap.put(resources.getString("PenDown").split("\\|")[1], new PenDown());
        commandMap.put(resources.getString("PenUp").split("\\|")[0], new PenUp());
        commandMap.put(resources.getString("PenUp").split("\\|")[1], new PenUp());
        commandMap.put(resources.getString("ShowTurtle").split("\\|")[0], new ShowTurtle());
        commandMap.put(resources.getString("ShowTurtle").split("\\|")[1], new ShowTurtle());
        commandMap.put(resources.getString("HideTurtle").split("\\|")[0], new HideTurtle());
        commandMap.put(resources.getString("HideTurtle").split("\\|")[1], new HideTurtle());
        commandMap.put(resources.getString("Home"), new Home());
        commandMap.put(resources.getString("ClearScreen").split("\\|")[0], new ClearScreen());
        commandMap.put(resources.getString("ClearScreen").split("\\|")[1], new ClearScreen());

        commandMap.put(resources.getString("XCoordinate"), new xCor());
        commandMap.put(resources.getString("YCoordinate"), new yCor());
        commandMap.put(resources.getString("Heading"), new Heading());
        commandMap.put(resources.getString("IsPenDown").split("\\|")[0], new PenStatus());
        commandMap.put(resources.getString("IsPenDown").split("\\|")[1], new PenStatus());
        commandMap.put(resources.getString("IsShowing").split("\\|")[0], new Showing());
        commandMap.put(resources.getString("IsShowing").split("\\|")[1], new Showing());

        commandMap.put(resources.getString("Sum").split("\\|")[0], new Sum());
        commandMap.put(resources.getString("Sum").split("\\|")[1], new Sum());
        commandMap.put(resources.getString("Difference").split("\\|")[0], new Difference());
        commandMap.put(resources.getString("Difference").split("\\|")[1], new Difference());
        commandMap.put(resources.getString("Product").split("\\|")[0], new Product());
        commandMap.put(resources.getString("Product").split("\\|")[1], new Product());
        commandMap.put(resources.getString("Quotient").split("\\|")[0], new Quotient());
        commandMap.put(resources.getString("Quotient").split("\\|")[1], new Quotient());
        commandMap.put(resources.getString("Remainder").split("\\|")[0], new Remainder());
        commandMap.put(resources.getString("Remainder").split("\\|")[1], new Remainder());
        commandMap.put(resources.getString("Minus").split("\\|")[0], new Minus());
        commandMap.put(resources.getString("Minus").split("\\|")[1], new Minus());
        commandMap.put(resources.getString("Random"), new Random());
        commandMap.put(resources.getString("Sine"), new Sin());
        commandMap.put(resources.getString("Cosine"), new Cos());
        commandMap.put(resources.getString("Tangent"), new Tan());
        commandMap.put(resources.getString("ArcTangent"), new Atan());
        commandMap.put(resources.getString("NaturalLog"), new Log());
        commandMap.put(resources.getString("Power"), new Pow());
        commandMap.put(resources.getString("Pi"), new Pi());

        commandMap.put(resources.getString("LessThan").split("\\|")[0], new Less());
        commandMap.put(resources.getString("LessThan").split("\\|")[1], new Less());
        commandMap.put(resources.getString("GreaterThan").split("\\|")[0], new Greater());
        commandMap.put(resources.getString("GreaterThan").split("\\|")[1], new Greater());
        commandMap.put(resources.getString("Equal").split("\\|")[0], new Equal());
        commandMap.put(resources.getString("Equal").split("\\|")[1], new Equal());
        commandMap.put(resources.getString("NotEqual").split("\\|")[0], new NotEqual());
        commandMap.put(resources.getString("NotEqual").split("\\|")[1], new NotEqual());
        commandMap.put(resources.getString("And"), new And());
        commandMap.put(resources.getString("Or"), new Or());
        commandMap.put(resources.getString("Not"), new NotEqual());

        commandMap.put(resources.getString("MakeVariable").split("\\|")[0], new Make());
        commandMap.put(resources.getString("MakeVariable").split("\\|")[1], new Make());
        commandMap.put(resources.getString("Repeat"), new Remainder());
        commandMap.put(resources.getString("DoTimes"), new DoTimes());
        commandMap.put(resources.getString("For"), new For());
        commandMap.put(resources.getString("If"), new If());
        commandMap.put(resources.getString("IfElse"), new IfElse());
        commandMap.put(resources.getString("MakeUserInstruction"), new To());

        commandMap.put(resources.getString("SetBackground").split("\\|")[0], new SetBackground());
        commandMap.put(resources.getString("SetBackground").split("\\|")[1], new SetBackground());
        commandMap.put(resources.getString("SetPenColor").split("\\|")[0], new SetPenColor());
        commandMap.put(resources.getString("SetPenColor").split("\\|")[1], new SetPenColor());
        commandMap.put(resources.getString("GetPenColor").split("\\|")[0], new GetPenColor());
        commandMap.put(resources.getString("GetPenColor").split("\\|")[1], new GetPenColor());

        return commandMap;
    }
}
