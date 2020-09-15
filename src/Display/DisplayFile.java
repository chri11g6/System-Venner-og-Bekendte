package Display;

public class DisplayFile implements iDisplay {

    @Override
    public void printHelp() {
        defaultPrintHelp();
        System.out.println("'save' gem person data i csv file");
        System.out.println("'load' load en csv med person data");
    }


    @Override
    public void printView() {}
    
}
