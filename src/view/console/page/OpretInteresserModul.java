package view.console.page;

import data.dataType.Global;
import data.dataType.Interesser;
import view.console.display.DisplayOpretInteresser;
import view.console.display.iDisplay;

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