package page;

import DataType.Global;
import DataType.Interesser;
import Display.DisplayOpretInteresser;
import Display.iDisplay;

public class OpretInteresserModul implements iPageModul {

    private iDisplay display = new DisplayOpretInteresser();

    @Override
    public void run() {

        Global.sti.push("interesser");

        System.out.println("Hvad er dit fornavn?");

        Interesser interesser = new Interesser(display.getInputString(Global.getSti()));

        Global.interesserList.add(interesser);

        Global.sti.pop();
    }
    
}
