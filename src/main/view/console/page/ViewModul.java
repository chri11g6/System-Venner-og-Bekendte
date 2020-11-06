package main.view.console.page;

import main.logic.Global;
import main.view.console.display.DisplayView;
import main.view.console.display.PrintTools;
import main.view.console.display.iDisplay;

public class ViewModul implements iPageModul {

	private iDisplay display = new DisplayView();
	private iPageModul personView = new ViewPersonModul();

	@Override
	public void run() {
		boolean isRun = true;

		Global.sti.push("View");

		do {

			String[] key = display.getInputString(Global.getSti()).split(" ");

			switch (key[0]) {
				case "h":
				case "help":
					display.printHelp();
					break;
				case "person":
					try {
						if (key.length >= 2) {

							Global.setPersonHolder(Global.personList.get(Integer.parseInt(key[1])));

							personView.run();
						} else {
							PrintTools.printPersonList(Global.personList.getAllAsList());
						}
					} catch (Exception e) {
						display.printLine();
						System.out.println("Kunne ikke Hente denne parmeter fordi:");
						System.out.println(e.getMessage());
						display.printLine();
					}
					break;
				case "interesser":
					PrintTools.printInteresserList(Global.interesserList.getAllAsList());
					break;
				case "pwd":
					System.out.println("Du er på view");
					break;
				case "q":
				case "exit":
					isRun = false;
					break;
				default:
					System.out.println("'h' eller 'help' For at få hjælp");
					break;
			}

		} while (isRun);
		Global.sti.pop();
	}

}
