package page;

import DataType.Global;
import Display.DisplayFile;
import Display.iDisplay;
import IO.File;
import IO.CSV.CsvPerson;
import IO.JSON.JsonAll;
import IO.JSON.JsonInteresser;
import IO.JSON.JsonPerson;

public class FileModul implements iPageModul {

    private iDisplay display = new DisplayFile();

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
                    System.out.println("Denne funktion er midlertidig ikke funktionær");
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

    public void saveToCSV() {
        try {
            System.out.println("Hvor skal den gemme henne?");
            String path = display.getInputString(Global.getSti() + "> Save");
            String data = CsvPerson.encode(Global.personList);

            File.write(data, path);
        } catch (Exception e) {
            display.printLine();
            System.out.println("Kunne ikke save file fordi:");
            System.out.println(e.getMessage());
            display.printLine();
        }
    }

    public void saveToJSON(String type) {
        try {
            System.out.println("Hvor skal den gemme henne?");
            String path = display.getInputString(Global.getSti() + "> Save");
            String data = "";
            switch (type) {
                case "all":
                    data = JsonAll.encodeToString(Global.personList, Global.interesserList);
                    break;
                case "personlist":
                    data = JsonPerson.encodeToString(Global.personList);
                    break;
                case "interesserlist":
                    data = JsonInteresser.encodeToString(Global.interesserList);
                    break;
                default:
                    throw new IllegalArgumentException("Kan ikke finde den type: " + type);
            }

            File.write(data, path);
        } catch (Exception e) {
            display.printLine();
            System.out.println("Kunne ikke save file fordi:");
            System.out.println(e.getMessage());
            display.printLine();
        }
    }
}
