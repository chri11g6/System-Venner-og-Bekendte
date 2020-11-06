package main.view.console.page;

import main.logic.Global;
import main.view.console.display.DisplayViewPerson;
import main.view.console.display.iDisplay;

public class ViewPersonModul implements iPageModul {

	private iDisplay display = new DisplayViewPerson();
	private iPageModul editPersonInteresser = new EditPersonInteresserModul();

	@Override
	public void run() {
		boolean isRun = true;

		Global.sti.push("Person");

		display.printView();

		do {

			String[] key = display.getInputString(Global.getSti()).split(" ");

			switch (key[0]) {
				case "h":
				case "help":
					display.printHelp();
					break;
				case "view":
					display.printView();
					break;
				case "edit":
					try {
						switch (key[1]) {
							case "interesser":
								editPersonInteresser.run();
								break;
							default:
								throw new IllegalArgumentException("Den parmeter finds ikke [" + key[1] + "]");
						}
					} catch (Exception e) {
						display.printLine();
						System.out.println("Kunne ikke sætte denne parmeter fordi:");
						System.out.println(e.getMessage());
						display.printLine();
					}
					break;
				case "set":
					try {
						switch (key[1]) {
							case "fornavn":
								Global.getPersonHolder().setForNavn(key[2]);
								break;
							case "efternavn":
								Global.getPersonHolder().setEfterNavn(key[2]);
								break;
							case "fødselsdage":
								Global.getPersonHolder().getBirthday().setBirthdays(key[2]);
								break;
							case "telefon":
								Global.getPersonHolder().setTelefon(key[2]);
								break;
							case "email":
								Global.getPersonHolder().setEmail(key[2]);
								break;
							default:
								throw new IllegalArgumentException("Den parmeter finds ikke [" + key[1] + "]");
						}
					} catch (Exception e) {
						display.printLine();
						System.out.println("Kunne ikke sætte denne parmeter fordi:");
						System.out.println(e.getMessage());
						display.printLine();
					}
					break;
				case "get":
					try {
						switch (key[1]) {
							case "fornavn":
								System.out.println(Global.getPersonHolder().getForNavn());
								break;
							case "efternavn":
								System.out.println(Global.getPersonHolder().getEfterNavn());
								break;
							case "alder":
								System.out.println(Global.getPersonHolder().getBirthday().getAlder());
								break;
							case "telefon":
								System.out.println(Global.getPersonHolder().getTelefon());
								break;
							case "email":
								System.out.println(Global.getPersonHolder().getEmail());
								break;
							default:
								throw new IllegalArgumentException("Den parmeter finds ikke [" + key[1] + "]");
						}
					} catch (Exception e) {
						display.printLine();
						System.out.println("Kunne ikke Hente denne parmeter fordi:");
						System.out.println(e.getMessage());
						display.printLine();
					}
					break;
				case "pwd":
					System.out.println("Du er på Person view og du ser på " + Global.getPersonHolder().getForNavn() + " "
							+ Global.getPersonHolder().getEfterNavn());
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
