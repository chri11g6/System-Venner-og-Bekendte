package view.console.page;

import logic.Global;
import logic.SaveAndLoad;
import logic.iSaveAndLoad;
import view.console.display.DisplayFile;
import view.console.display.iDisplay;

public class FileModul implements iPageModul {

    private iDisplay display = new DisplayFile();

    private iSaveAndLoad saveAndLoad = new SaveAndLoad();

    @Override
    public void run() {
        Global.sti.push("File");

        boolean isRun = true;

        do {

            String[] key = display.getInputString(Global.getSti()).split(" ");

            switch (key[0]) {
                case "h":
                case "help":
                    display.printHelp();
                    break;
                case "save":
                    if(key.length > 1){
                        // saveToCSV();
                        saveToJSON(key[1]);
                    }
                    break;
                case "load":
                    loadToJSON(key[1]);
                    break;
                case "pwd":
                    System.out.println("Du er i file måde");
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

    // public void saveToCSV() {
    //     try {
    //         System.out.println("Hvor skal den gemme henne?");
    //         String path = display.getInputString(Global.getSti() + "> Save");
    //         String data = CsvPerson.encode(Global.personList);

    //         FileIO.write(data, path);
    //     } catch (Exception e) {
    //         display.printLine();
    //         System.out.println("Kunne ikke save file fordi:");
    //         System.out.println(e.getMessage());
    //         display.printLine();
    //     }
    // }

    public void saveToJSON(String type) {
        try {
            System.out.println("Hvor skal den gemme henne?");
            String path = display.getInputString(Global.getSti() + "> Save");
            switch (type) {
                case "all":
                    saveAndLoad.saveAllAsJSON(path);
                    break;
                case "personlist":
                    saveAndLoad.savePersonsAsJSON(path);
                    break;
                case "interesserlist":
                    saveAndLoad.saveInteressersAsJSON(path);
                    break;
                default:
                    throw new IllegalArgumentException("Kan ikke finde den type: " + type);
            }
        } catch (Exception e) {
            display.printLine();
            System.out.println("Kunne ikke save file fordi:");
            System.out.println(e.getMessage());
            display.printLine();
        }
    }

    public void loadToJSON(String type) {
        try {
            System.out.println("Hvor skal den hent den?");
            String path = display.getInputString(Global.getSti() + "> Load");
            switch (type) {
                case "all":
                    saveAndLoad.loadAllAsJSON(path);
                    break;
                case "personlist":
                    saveAndLoad.loadPersonsAsJSON(path);
                    break;
                case "interesserlist":
                    saveAndLoad.loadInteressersAsJSON(path);
                    break;
                default:
                    throw new IllegalArgumentException("Kan ikke finde den type: " + type);
            }

        } catch (Exception e) {
            display.printLine();
            System.out.println("Kunne ikke load file fordi:");
            System.out.println(e.getMessage());
            display.printLine();
        }
    }
}
