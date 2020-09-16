package IO.JSON;

import java.util.ArrayList;

import org.json.JSONArray;

import DataType.Interesser;

public class JsonInteresser {

    public static String encodeToString(ArrayList<Interesser> interessers) {
        return encode(interessers).toString();
    }

    public static JSONArray encode(ArrayList<Interesser> datas) {
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < datas.size(); i++) {
            jsonArray.put(datas.get(i).navn);

        }
        return jsonArray;
    }

    public static void decode(String data) {
        // TODO Auto-generated method stub

    }
    
}
