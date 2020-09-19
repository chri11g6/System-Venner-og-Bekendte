package view.console.page;

import data.DataType.Global;
import data.DataType.Interesser;
import data.DataType.Person;
import view.console.Display.DisplayOpretPerson;
import view.console.Display.iDisplay;

public class OpretPersonModul implements iPageModul {

    private iDisplay display = new DisplayOpretPerson();
    private iPageModul opretInteresserNew = new OpretInteresserModul();

    @Override
    public void run() {
        try {
            Person person = new Person();
            Global.sti.push("Opret");
            String textToInput = Global.getSti();

            display.printLine();

            System.out.println("Hvad er dit fornavn?");
            person.forNavn = display.getInputString(textToInput);

            System.out.println("Hvad er dit efternavn?");
            person.efterNavn = display.getInputString(textToInput);

            System.out.println("Hvad er din alder?");
            person.alder = Integer.parseInt(display.getInputString(textToInput));

            System.out.println("Hvad er dit telefon nummer?");
            person.setTelefon(display.getInputString(textToInput));

            System.out.println("Hvad er din email?");
            person.setEmail(display.getInputString(textToInput));

            display.printView();

            boolean isRun = true;
            
            do{
                String[] key = display.getInputString("add").split(" ");

                switch(key[0]){
                    case "h":
                    case "help":
                        display.printHelp();
                        break;
                    case "add":
                        Interesser interesserData = Global.interesserList.get(Integer.parseInt(key[1]));

                        if(person.interesser.indexOf(interesserData) == -1){
                            person.interesser.add(interesserData);
                            System.out.println("Interesse: " + interesserData.navn + " er nu tilføjet.");
                        }else{
                            System.out.println("Den interesse: " + interesserData.navn + " er tilføjet.");
                        }

                        break;
                    case "add-new":
                        int lastIndex = Global.interesserList.size();

                        opretInteresserNew.run();

                        Interesser interesserNewData = Global.interesserList.get(lastIndex);

                        person.interesser.add(interesserNewData);

                        break;

                    case "view-list":
                        printPersonInteresserList(person);
                        break;
                    case "view-glodal-list":
                        display.printView();
                        break;
                    case "pwd":
                        System.out.println("Du er hved at tilføjer interesser til den person du er ved at opret");
                        break; 
                    case "q":
                    case "exit":
                        isRun = false;
                        break;
                    default:
                        System.out.println("'h' eller 'help' For at få hjælp til interesser");
                }
            }while(isRun);


            Global.personList.add(person);

        } catch (Exception e){
            display.printLine();
            System.out.println("Kunne ikke opret person fordi:");
            System.out.println(e.getMessage());
            display.printLine();
        }

        Global.sti.pop();
    }
    
    private void printPersonInteresserList(Person person){
        display.printLine();
        for(int i = 0; i < person.interesser.size(); i++){
            System.out.println(person.interesser.get(i).navn);
        }
        display.printLine();
    }
}
