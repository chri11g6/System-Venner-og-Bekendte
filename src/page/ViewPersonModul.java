package page;

import DataType.Global;
import Display.DisplayViewPerson;
import Display.iDisplay;

public class ViewPersonModul implements iPageModul {

    private iDisplay display = new DisplayViewPerson();

    @Override
    public void run() {
        boolean isRun = true;

        display.printView();

        do {

            String key = display.getInputString("Person");

            switch (key) {
                case "h":
                case "help":
                    display.printHelp();
                    break;  
                case "pwd":
                    System.out.println("Du er på Person view og du ser på " + Global.personHolder.forNavn + " " + Global.personHolder.efterNavn);
                    break;                
                case "q":
                case "exit":
                    isRun = false;
                    break;
                default:
                    System.out.println("'h' eller 'help' For at få hjælp");
                    break;
            }

        } while (isRun);

    }
    
}
