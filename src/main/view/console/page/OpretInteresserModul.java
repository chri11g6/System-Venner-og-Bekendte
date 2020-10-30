package main.view.console.page;

import main.logic.Global;
import main.dto.Interesser;
import main.dto.iInteresser;
import main.view.console.display.DisplayOpretInteresser;
import main.view.console.display.iDisplay;

public class OpretInteresserModul implements iPageModul {

	private iDisplay display = new DisplayOpretInteresser();

	@Override
	public void run() {

		Global.sti.push("interesser");

		System.out.println("Hvad er interesse navn?");

		iInteresser interesser = new Interesser(display.getInputString(Global.getSti()));

		Global.interesserList.add(interesser);

		Global.sti.pop();
	}

}
