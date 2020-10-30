package main;

import main.logic.Global;
import main.dto.Interesser;
import main.dto.Person;
import main.dto.iPerson;
import main.view.ViewFactory;
import main.view.iView;

public class App {
	public static void main(String[] args) throws Exception {
		load();

		// iView menu = ViewFactory.getGUI();
		iView menu = ViewFactory.getConsole();

		menu.run();

	}

	private static void load() {
		Global.interesserList.add(new Interesser("Skak"));
		Global.interesserList.add(new Interesser("CounterStrike"));
		Global.interesserList.add(new Interesser("Litteratur"));
		Global.interesserList.add(new Interesser("Natur"));

		iPerson per = new Person();
		per.setForNavn("Christian");
		per.setEfterNavn("Christensen");
		per.getBirthday().setBirthdays("26-09-1994");
		per.setTelefon("12345678");
		per.setEmail("chri11g6@eamv.dk");

		iPerson per1 = new Person();
		per1.setForNavn("Martin");
		per1.setEfterNavn("Christensen");
		per1.getBirthday().setBirthdays("02-04-1990");
		per1.setTelefon("12345678");
		per1.setEmail("");

		iPerson per2 = new Person();
		per2.setForNavn("Antia");
		per2.setEfterNavn("Christensen");
		per2.getBirthday().setBirthdays("21-10-1962");
		per2.setTelefon("12345678");
		per2.setEmail("");

		Global.personList.add(per);
		Global.personList.add(per1);
		Global.personList.add(per2);
	}
}