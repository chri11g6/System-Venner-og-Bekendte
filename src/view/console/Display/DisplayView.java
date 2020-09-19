package view.console.Display;

public class DisplayView implements iDisplay {
    
    @Override
    public void printHelp() {
        defaultPrintHelp();
        System.out.println("'person' se list af personer");
        System.out.println("'interesser' se list af interesser");
    }

    @Override
    public void printView() {}

}
