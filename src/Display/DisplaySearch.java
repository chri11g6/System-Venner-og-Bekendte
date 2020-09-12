package Display;

public class DisplaySearch implements iDisplay {

    @Override
    public void printHelp() {
        defaultPrintHelp();
        System.out.println("'person [permeter] [text] [operator] ...'");
        System.out.println("'[operator]' \n\t- 'not'\n\t- 'or'\n\t- 'and'");
        System.out.println("'[permeter]' \n\t- 'fornavn'\n\t- 'efternavn'\n\t- 'telefon'\n\t- 'email'\n\t- 'interesser'");
        System.out.println("'[text]' søge order");
        System.out.println("'interesser [text] [operator] ...'");
        System.out.println("'[operator]' \n\t- 'not'\n\t- 'or'\n\t- 'and'");
        System.out.println("'[text]' søge order for interesser");
    }

    @Override
    public void printView() {}
    
}
