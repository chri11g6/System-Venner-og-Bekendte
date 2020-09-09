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

            String[] key = display.getInputString("Person").split(" ");

            switch (key[0]) {
                case "h":
                case "help":
                    display.printHelp();
                    break;
                case "set":
                    try {
                        switch (key[1]) {
                            case "fornavn":
                                Global.personHolder.forNavn = key[2];
                                break;
                            case "efternavn":
                                Global.personHolder.efterNavn = key[2];
                                break;
                            case "alder":
                                Global.personHolder.alder = Integer.parseInt(key[2]);
                                break;
                            case "telefon":
                                Global.personHolder.setTelefon(key[2]);
                                break;
                            case "email":
                                Global.personHolder.setEmail(key[2]);
                                break;
                            default:
                                throw new IllegalArgumentException("Den parmeter finds ikke [" + key[1] + "]");
                        }
                    } catch (Exception e){
                        display.printLine();
                        System.out.println("Kunne ikke sætte denne parmeter fordi:");
                        System.out.println(e.getMessage());
                        display.printLine();
                    }
                    break;
                case "get":
                    try {
                        switch (key[1]) {
                            case "fornavn":
                                System.out.println(Global.personHolder.forNavn);
                                break;
                            case "efternavn":
                                System.out.println(Global.personHolder.efterNavn);
                                break;
                            case "alder":
                                System.out.println(Global.personHolder.alder);
                                break;
                            case "telefon":
                                System.out.println(Global.personHolder.getTelefon());
                                break;
                            case "email":
                                System.out.println(Global.personHolder.getEmail());
                                break;
                            default:
                                throw new IllegalArgumentException("Den parmeter finds ikke [" + key[1] + "]");
                        }
                    } catch (Exception e){
                        display.printLine();
                        System.out.println("Kunne ikke Hente denne parmeter fordi:");
                        System.out.println(e.getMessage());
                        display.printLine();
                    }
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
