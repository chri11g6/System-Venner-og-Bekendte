package Display;

public class DisplayMenu implements iDisplay {

    @Override
    public void printHelp() {
        defaultPrintHelp();
        System.out.println("'opret' for at tilføjer en ny person");
        System.out.println("'view' gå til view måde");
    }

    @Override
    public void printView() {
        // TODO Auto-generated method stub

    }
    
}
