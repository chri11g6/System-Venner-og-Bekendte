package main.view.console.page;

import main.dto.iInteresser;
import main.logic.Global;
import main.dto.Interesser;
import main.view.console.display.DisplayEditPersonInteresser;
import main.view.console.display.PrintTools;
import main.view.console.display.iDisplay;

public class EditPersonInteresserModul implements iPageModul {

	private iDisplay display = new DisplayEditPersonInteresser();

	@Override
	public void run() {
		boolean isRun = true;

		Global.sti.push("Interesser");

		display.printView();

		do {

			String[] key = display.getInputString(Global.getSti()).split(" ");

			switch (key[0]) {
				case "h":
				case "help":
					display.printHelp();
					break;
				case "view":
					if (key.length > 1 && key[1].equalsIgnoreCase("global")) {
						display.printLine();
						System.out.println("Global interesser list");
						PrintTools.printInteresserList(Global.interesserList.getAllAsList());
					} else {
						display.printLine();
						System.out.println("Person's interesser list");
						display.printView();
					}
					break;
				case "add":
					try {
						if (key.length > 1 && key[1] == "new") {
							System.out.println("Hvad er den nye interesser");
							iInteresser newInteresser = new Interesser(
									display.getInputString(Global.getSti() + " > Nye"));
							Global.getPersonHolder().getPersonInteresserList().getInteresser().add(newInteresser);
							Global.interesserList.add(newInteresser);
						} else {
							Global.getPersonHolder().getPersonInteresserList().getInteresser().add(Global.interesserList.get(Integer.parseInt(key[1])));
						}
					} catch (Exception e) {
						display.printLine();
						System.out.println("Kunne ikke sætte denne parmeter fordi:");
						System.out.println(e.getMessage());
						display.printLine();
					}
					break;
				case "remove":
					try {
						Global.getPersonHolder().getPersonInteresserList().getInteresser().remove(Integer.parseInt(key[1]));
					} catch (Exception e) {
						display.printLine();
						System.out.println("Kunne ikke sætte denne parmeter fordi:");
						System.out.println(e.getMessage());
						display.printLine();
					}
					break;
				case "pwd":
					System.out.println("Du er på Person view og du ser på " + Global.getPersonHolder().getForNavn() + " "
							+ Global.getPersonHolder().getEfterNavn() + " interesser");
					break;
				case "q":
				case "exit":
					isRun = false;

					for (int i = 0; i < Global.personList.size(); i++) {
						if (Global.personList.get(i).getId() == Global.getPersonHolder().getId()) {
							Global.personList.update(Global.getPersonHolder(), i);
							break;
						}
					}

					break;
				default:
					System.out.println("'h' eller 'help' For at få hjælp");
					break;
			}

		} while (isRun);

		Global.sti.pop();

	}

}
