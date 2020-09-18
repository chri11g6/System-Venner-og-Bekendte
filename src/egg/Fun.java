package egg;

import java.util.ArrayList;
import java.util.Random;

import org.json.JSONArray;

import IO.File;

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
        // Data file komme ikke med til git fordi copyright
        try{
            JSONArray dataList = new JSONArray(File.read("./src/egg/data.json"));
            
            for(int i = 0; i < dataList.length(); i++){
                list.add(dataList.getString(i));
            }

        } catch (Exception e) {}
    }
}
