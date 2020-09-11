package Display;

public class DisplaySearch implements iDisplay {

    @Override
    public void printHelp() {
        defaultPrintHelp();
        System.out.println("'search [permeter] [text] [operator] ...'");
        System.out.println("'[operator]' \n\t- 'not'\n\t- 'or'\n\t- 'and'");
        System.out.println("'[permeter]' \n\t- 'fornavn'\n\t- 'efternavn'\n\t- 'telefon'\n\t- 'email'\n\t- 'interesser'");
        System.out.println("'[text]' søge order");
    }

    @Override
    public void printView() {}
    
}