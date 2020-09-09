package page;

import DataType.Global;
import DataType.Person;
import DataType.Tools;
import Display.DisplayView;
import Display.iDisplay;

public class ViewModul implements iPageModul {

    private iDisplay display = new DisplayView();
    private iPageModul personView = new ViewPersonModul();

    @Override
    public void run() {
        boolean isRun = true;

        do {

            String[] key = display.getInputString("View").split(" ");

            switch (key[0]) {
                case "h":
                case "help":
                    display.printHelp();
                    break;
                case "person":
                    try {
                        if (key[1] != null) {

                            Global.personHolder = Global.personList.get(Integer.parseInt(key[1]))

                            personView.run();
                        } else {
                            printPersonList();
                        }
                    } catch (Exception e) {
                        display.printLine();
                        System.out.println("Kunne ikke Hente denne parmeter fordi:");
                        System.out.println(e.getMessage());
                        display.printLine();
                    }
                    break;
                case "interesser":
                    printInteresserList();
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

    }

    private void printInteresserList() {
        int maxSizeId = 2;
        int maxSizeInteresser = 10;

        maxSizeId = Math.max(maxSizeId, String.valueOf(Global.interesserList.size()).length());

        for (int i = 0; i < Global.interesserList.size(); i++) {
            maxSizeInteresser = Math.max(maxSizeInteresser, Global.interesserList.get(i).navn.length());
        }

        StringBuilder header = new StringBuilder();

        header.append("ID");
        header.append(Tools.loopString(maxSizeId, " "));
        header.append("Interesser");

        System.out.println("");
        System.out.println(header.toString());
        System.out.println(Tools.loopString(maxSizeId + maxSizeInteresser, "-"));

        for (int i = 0; i < Global.interesserList.size(); i++) {
            StringBuilder interesserText = new StringBuilder();
            interesserText.append(i);
            interesserText.append(Tools.loopString(maxSizeId - String.valueOf(i).length() + 2, " "));
            interesserText.append(Global.interesserList.get(i).navn);
            System.out.println(interesserText.toString());
        }
        System.out.println("");
    }

    private void printPersonList() {
        int maxSizeForNavn = 7;
        int maxSizeId = 2;
        int maxSizeEfterNavn = 9;
        int maxSizeAlder = 5;
        int maxSizeTelefon = 7;
        int maxSizeEmail = 5;
        int addSpaceTo = 2;

        for (int i = 0; i < Global.personList.size(); i++) {
            Person person = Global.personList.get(i);
            maxSizeForNavn = Math.max(maxSizeForNavn, person.forNavn.length());
            maxSizeEfterNavn = Math.max(maxSizeEfterNavn, person.efterNavn.length());
            maxSizeTelefon = Math.max(maxSizeTelefon, person.getTelefon().length());
            maxSizeEmail = Math.max(maxSizeEmail, person.getEmail().length());
            maxSizeAlder = Math.max(maxSizeAlder, String.valueOf(person.alder).length());
        }

        maxSizeId = Math.max(maxSizeId, String.valueOf(Global.personList.size()).length());

        StringBuilder header = new StringBuilder();

        header.append("ID");
        header.append(Tools.loopString(maxSizeId - 2 + addSpaceTo, " "));
        header.append("Fornavn");
        header.append(Tools.loopString(maxSizeForNavn - 7 + addSpaceTo, " "));
        header.append("Efternavn");
        header.append(Tools.loopString(maxSizeEfterNavn - 9 + addSpaceTo, " "));
        header.append("Alder");
        header.append(Tools.loopString(maxSizeAlder - 5 + addSpaceTo, " "));
        header.append("Telefon");
        header.append(Tools.loopString(maxSizeTelefon - 7 + addSpaceTo, " "));
        header.append("Email");
        header.append(Tools.loopString(maxSizeEmail - 5 + addSpaceTo, " "));
        header.append("Interesser");

        System.out.println("");
        System.out.println(header.toString());
        System.out.println(Tools.loopString(header.length(), "-"));

        for (int i = 0; i < Global.personList.size(); i++) {
            Person person = Global.personList.get(i);
            StringBuilder personText = new StringBuilder();

            personText.append(i);
            personText.append(Tools.loopString(maxSizeId - String.valueOf(i).length() + addSpaceTo, " "));
            personText.append(person.forNavn);
            personText.append(Tools.loopString(maxSizeForNavn - person.forNavn.length() + addSpaceTo, " "));
            personText.append(person.efterNavn);
            personText.append(Tools.loopString(maxSizeEfterNavn - person.efterNavn.length() + addSpaceTo, " "));
            personText.append(person.alder);
            personText.append(Tools.loopString(maxSizeAlder - String.valueOf(person.alder).length() + addSpaceTo, " "));
            personText.append(person.getTelefon());
            personText.append(
                    Tools.loopString(maxSizeTelefon - String.valueOf(person.getTelefon()).length() + addSpaceTo, " "));
            personText.append(person.getEmail());
            personText.append(
                    Tools.loopString(maxSizeEmail - String.valueOf(person.getEmail()).length() + addSpaceTo, " "));

            for (int j = 0; j < person.interesser.size(); j++) {
                personText.append(person.interesser.get(j).navn);
                if (j < person.interesser.size() - 1) {
                    personText.append(", ");
                }
            }

            System.out.println(personText.toString());
        }
        System.out.println("");
    }

}
