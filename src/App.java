import DataType.Global;
import DataType.Interesser;
import Display.DisplayMenu;
import Display.iDisplay;
import page.OpretPersonModul;
import page.ViewModul;
import page.iPageModul;

public class App {
    public static void main(String[] args) throws Exception {
        load();
        boolean isRun = true;

        iDisplay display = new DisplayMenu();

        iPageModul opretPersonModul = new OpretPersonModul();
        iPageModul viewModul = new ViewModul();

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

    private static void load() {
        Global.interesserList.add(new Interesser("Skak"));
        Global.interesserList.add(new Interesser("CounterStrike"));
        Global.interesserList.add(new Interesser("Litteratur"));
        Global.interesserList.add(new Interesser("Natur"));
    }
}
