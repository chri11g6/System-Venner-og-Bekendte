package main.view.console.page;

import main.logic.Global;
// import main.dto.Interesser;
import main.dto.Person;
import main.dto.iInteresser;
import main.dto.iPerson;
import main.view.console.display.DisplayOpretPerson;
import main.view.console.display.iDisplay;

public class OpretPersonModul implements iPageModul {

	private iDisplay display = new DisplayOpretPerson();
	private iPageModul opretInteresserNew = new OpretInteresserModul();

	@Override
	public void run() {
		try {
			iPerson person = new Person();
			Global.sti.push("Opret");
			String textToInput = Global.getSti();

			display.printLine();

			System.out.println("Hvad er dit fornavn?");
			person.setForNavn(display.getInputString(textToInput));

			System.out.println("Hvad er dit efternavn?");
			person.setEfterNavn(display.getInputString(textToInput));

			System.out.println("Hvad er din fødselsdage? [dd-MM-yyyy]");
			person.getBirthday().setBirthdays(display.getInputString(textToInput));

			System.out.println("Hvad er dit telefon nummer?");
			person.setTelefon(display.getInputString(textToInput));

			System.out.println("Hvad er din email?");
			person.setEmail(display.getInputString(textToInput));

			display.printView();

			boolean isRun = true;

			do {
				String[] key = display.getInputString("add").split(" ");

				switch (key[0]) {
					case "h":
					case "help":
						display.printHelp();
						break;
					case "add":
						iInteresser interesserData = Global.interesserList.get(Integer.parseInt(key[1]));

						if (person.getInteresser().indexOf(interesserData) == -1) {
							person.getInteresser().add(interesserData);
							System.out.println("Interesse: " + interesserData.getNavn() + " er nu tilføjet.");
						} else {
							System.out.println("Den interesse: " + interesserData.getNavn() + " er tilføjet.");
						}

						break;
					case "add-new":
						int lastIndex = Global.interesserList.size();

						opretInteresserNew.run();

						iInteresser interesserNewData = Global.interesserList.get(lastIndex);

						person.getInteresser().add(interesserNewData);

						break;

					case "view-list":
						printPersonInteresserList(person);
						break;
					case "view-glodal-list":
						display.printView();
						break;
					case "pwd":
						System.out.println("Du er hved at tilføjer interesser til den person du er ved at opret");
						break;
					case "q":
					case "exit":
						isRun = false;
						break;
					default:
						System.out.println("'h' eller 'help' For at få hjælp til interesser");
				}
			} while (isRun);

			Global.personList.add(person);

		} catch (Exception e) {
			display.printLine();
			System.out.println("Kunne ikke opret person fordi:");
			System.out.println(e.getMessage());
			display.printLine();
		}

		Global.sti.pop();
	}

	private void printPersonInteresserList(iPerson person) {
		display.printLine();
		for (int i = 0; i < person.getInteresser().size(); i++) {
			System.out.println(person.getInteresser().get(i).getNavn());
		}
		display.printLine();
	}
}
