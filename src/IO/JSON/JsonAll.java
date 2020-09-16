package IO.JSON;

import java.util.ArrayList;

import org.json.JSONObject;

import DataType.Interesser;
import DataType.Person;

public class JsonAll {
    public static String encodeToString(ArrayList<Person> persons, ArrayList<Interesser> interessers) {
        return encode(persons, interessers).toString();
    }

    public static JSONObject encode(ArrayList<Person> persons, ArrayList<Interesser> interessers) {
        JSONObject json = new JSONObject();

        json.put("persons", JsonPerson.encode(persons));
        json.put("interessers", JsonInteresser.encode(interessers));

        return json;
    }

    public static void decode(String data) {
        // TODO Auto-generated method stub

    }
}
