import DataType.Global;
import DataType.Interesser;
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
    }
}
