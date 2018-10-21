package commands;

import java.util.Scanner;

public class ClearScreen implements Command {

    @Override
    public void run(Scanner args){
        System.out.println("Clear screen");
    }

}
