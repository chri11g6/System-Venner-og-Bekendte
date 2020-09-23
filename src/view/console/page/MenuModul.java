package view.console.page;

import logic.Global;
import view.console.display.DisplayMenu;
import view.console.display.iDisplay;

public class MenuModul implements iPageModul {

    private iDisplay display = new DisplayMenu();

    private iPageModul opretPersonModul = new OpretPersonModul();
    private iPageModul viewModul = new ViewModul();
    private iPageModul searchModul = new SearchModul();
    private iPageModul fileMoudul = new FileModul();


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
                case "file":
                    fileMoudul.run();
                    break;
                case "status":
                    display.printLine();
                    System.out.println("Der er " + Global.personList.size() + " person registreret");
                    System.out.println("Der er " + Global.interesserList.size() + " interesser registreret");
                    display.printLine();
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
