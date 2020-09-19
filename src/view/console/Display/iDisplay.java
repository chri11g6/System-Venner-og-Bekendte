package view.console.display;

import java.util.Scanner;

public interface iDisplay {
    public void printView();

    default void defaultPrintHelp(){
        System.out.println("'q' eller 'exit' For at stoppe det du laver lige nu");
        System.out.println("'h' eller 'help' For at få hjælp");
        System.out.println("'pwd' Hvor er du?");
    }

    default void printHelp(){
        System.out.println("Der er ikke nogle hjælpe function");
    }

    default void printLine() {
        System.out.println("------------------------------------------------");
    }

    default String getInputString(String frontText){
        System.out.print(frontText + "> ");
        return ReadInput();
    }

    default String getInputString(){
        System.out.print("> ");
        return ReadInput();
    }

    private String ReadInput(){
        Scanner input = new Scanner(System.in, "ISO-8859-1");

        return input.nextLine();

        // String data = input.nextLine();

        // return data.toLowerCase();
    }
}
