package page;

import Display.DisplayMenu;
import Display.iDisplay;

public class MenuModul implements iPageModul {

    private iDisplay display = new DisplayMenu();

    private iPageModul opretPersonModul = new OpretPersonModul();
    private iPageModul viewModul = new ViewModul();
    private iPageModul searchModul = new SearchModul();


    @Override
    public void run() {
        boolean isRun = true;

        do {

            String key = display.getInputString();

            switch (key) {
                case "h":
                case "help":
                    display.printHelp();
                    break;
                case "opret":
                    opretPersonModul.run();
                    break;
                case "view":
                    viewModul.run();
                    break;                
                case "search":
                    searchModul.run();
                    break;                
                case "pwd":
                    System.out.println("Du er på menu'en");
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
