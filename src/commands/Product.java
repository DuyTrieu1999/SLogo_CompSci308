package commands;

import java.util.Scanner;

public class Product implements Command {

    @Override
    public void run(Scanner args){
        System.out.println("Product");
    }

}
