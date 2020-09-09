package Display;

import DataType.Global;

public class DisplayOpretPerson implements iDisplay {

    @Override
    public void printHelp() {
        defaultPrintHelp();
        System.out.println("'add' interesse til person");
        System.out.println("'add-new' opret en ny interesse til list og tilføjer til person");
        System.out.println("'view-list' For at se hvad der tilføjet til person'en");
        System.out.println("'view-glodal-list' For at se interesse listen");
    }

    @Override
    public void printView() {
        printLine();

        for (int i = 0; i < Global.interesserList.size(); i++) {
            
            if(i < 10){
                System.out.println(i + "  | " + Global.interesserList.get(i).navn);
            } else {
                System.out.println(i + " | " + Global.interesserList.get(i).navn);
            }
        }

        printLine();

    }

}
