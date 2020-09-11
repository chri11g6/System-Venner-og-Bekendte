import DataType.Global;
import DataType.Interesser;
import DataType.Person;
import page.MenuModul;
import page.iPageModul;

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

        Global.personList.add(per);
    }
}
