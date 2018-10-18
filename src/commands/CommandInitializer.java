package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandInitializer {

    private Map<String, Command> commandMap = new HashMap<>();

    public Map<String, Command> createCommandMap(Scanner s){

        commandMap.put("forward", new Forward());
        commandMap.put("fd", new Forward());
        commandMap.put("back", new Back());
        commandMap.put("bk", new Back());
        commandMap.put("left", new Left());
        commandMap.put("lt", new Left());
        commandMap.put("right", new Right());
        commandMap.put("rt", new Right());
        commandMap.put("setheading", new SetHeading());
        commandMap.put("seth", new SetHeading());
        commandMap.put("towards", new Towards());
        commandMap.put("setxy", new GoTo());
        commandMap.put("goto", new GoTo());
        commandMap.put("pendown", new PenDown());
        commandMap.put("pd", new PenDown());
        commandMap.put("penup", new PenUp());
        commandMap.put("pu", new PenUp());
        commandMap.put("showturtle", new ShowTurtle());
        commandMap.put("st", new ShowTurtle());
        commandMap.put("hideturtle", new HideTurtle());
        commandMap.put("ht", new HideTurtle());
        commandMap.put("home", new Home());
        commandMap.put("clearscreen", new ClearScreen());
        commandMap.put("cs", new ClearScreen());

        commandMap.put("xcor", new xCor());
        commandMap.put("ycor", new yCor());
        commandMap.put("heading", new Heading());
        commandMap.put("pendown?", new PenStatus());
        commandMap.put("pendownp", new PenStatus());
        commandMap.put("showing?", new Showing());
        commandMap.put("showingp", new Showing());

        commandMap.put("sum", new Sum());
        commandMap.put("difference", new Difference());
        commandMap.put("product", new Product());
        commandMap.put("quotient", new Quotient());
        commandMap.put("remainder", new Remainder());
        commandMap.put("minus", new Minus());
        commandMap.put("random", new Random());
        commandMap.put("sin", new Sin());
        commandMap.put("cos", new Cos());
        commandMap.put("tan", new Tan());
        commandMap.put("atan", new Atan());
        commandMap.put("low", new Log());
        commandMap.put("pow", new Pow());
        commandMap.put("pi", new Pi());

        commandMap.put("less?", new Less());
        commandMap.put("lessp", new Less());
        commandMap.put("greater?", new Greater());
        commandMap.put("greaterp", new Greater());
        commandMap.put("equal?", new Equal());
        commandMap.put("equalp", new Equal());
        commandMap.put("notequal?", new NotEqual());
        commandMap.put("notequalp", new NotEqual());
        commandMap.put("and", new And());
        commandMap.put("or", new Or());
        commandMap.put("not", new NotEqual());

        commandMap.put("make", new Make());
        commandMap.put("set", new Make());
        commandMap.put("repeat", new Remainder());
        commandMap.put("dotimes", new DoTimes());
        commandMap.put("for", new For());
        commandMap.put("if", new If());
        commandMap.put("ifelse", new IfElse());
        commandMap.put("to", new To());

        return commandMap;
    }
}
