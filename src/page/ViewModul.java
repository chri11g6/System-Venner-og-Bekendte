package page;

import DataType.Global;
import Display.DisplayView;
import Display.PrintTools;
import Display.iDisplay;

public class ViewModul implements iPageModul {

    private iDisplay display = new DisplayView();
    private iPageModul personView = new ViewPersonModul();

    @Override
    public void run() {
        boolean isRun = true;

        Global.sti.push("View");

        do {

            String[] key = display.getInputString(Global.getSti()).split(" ");

            switch (key[0]) {
                case "h":
                case "help":
                    display.printHelp();
                    break;
                case "person":
                    try {
                        if (key.length >= 2) {

                            Global.personHolder = Global.personList.get(Integer.parseInt(key[1]));

                            personView.run();
                        } else {
                            PrintTools.printPersonList();
                        }
                    } catch (Exception e) {
                        display.printLine();
                        System.out.println("Kunne ikke Hente denne parmeter fordi:");
                        System.out.println(e.getMessage());
                        display.printLine();
                    }
                    break;
                case "interesser":
                    PrintTools.printInteresserList();
                    break;
                case "pwd":
                    System.out.println("Du er på view");
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
        Global.sti.pop();
    }

    

}
