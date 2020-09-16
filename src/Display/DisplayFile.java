package Display;

public class DisplayFile implements iDisplay {

    @Override
    public void printHelp() {
        defaultPrintHelp();
        System.out.println("'save [type]' gem person data i json file");
        System.out.println("'[type]'\n\t- all\n\t- personlist\n\t- intersserlist");
        System.out.println("'load [type]' load en json med person data");
        System.out.println("'[type]'\n\t- all\n\t- personlist\n\t- intersserlist");
    }


    @Override
    public void printView() {}
    
}
