package egg;

import java.util.ArrayList;
import java.util.Random;

public class Fun {
    private static ArrayList<String> list = new ArrayList<String>();
    private Random ran = new Random();

    public Fun(){
        load();
    }

    public String getText() {
        if(list.size() == 0){
            return null;
        } else {
            return Fun.list.get(ran.nextInt(Fun.list.size()-1));      
        }
    }

    private static void load() {
        if (list.size() != 0) {
            return;
        }
        // Data komme ikke med til git fordi copyright
    }
}
