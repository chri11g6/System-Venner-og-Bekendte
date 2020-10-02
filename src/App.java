import logic.Global;
import dto.Interesser;
import dto.Person;
import view.console.page.MenuModul;
import view.console.page.iPageModul;

public class App {
	public static void main(String[] args) throws Exception {
		load();

		iPageModul menu = new MenuModul();

		menu.run();

	}

	private static void load() {
		Global.interesserList.add(new Interesser("Skak"));
		Global.interesserList.add(new Interesser("CounterStrike"));
		Global.interesserList.add(new Interesser("Litteratur"));
		Global.interesserList.add(new Interesser("Natur"));

		Person per = new Person();
		per.forNavn = "Christian";
		per.efterNavn = "Christensen";
		per.alder = 25;
		per.setTelefon("12345678");
		per.setEmail("chri11g6@eamv.dk");

		Person per1 = new Person();
		per1.forNavn = "Martin";
		per1.efterNavn = "Christensen";
		per1.alder = 25;
		per1.setTelefon("12345678");
		per1.setEmail("");

		Person per2 = new Person();
		per2.forNavn = "Anita";
		per2.efterNavn = "Christensen";
		per2.alder = 25;
		per2.setTelefon("12345678");
		per2.setEmail("");

		Global.personList.add(per);
		Global.personList.add(per1);
		Global.personList.add(per2);
	}
}
