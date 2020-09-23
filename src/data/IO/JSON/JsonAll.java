// https://github.com/stleary/JSON-java

package data.io.json;

import java.util.ArrayList;

import org.json.JSONObject;

import dto.dataType.Interesser;
import dto.dataType.Person;

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

    public static Object[] decode(String data) {
        JSONObject Json = new JSONObject(data);

        ArrayList<Person> personList = JsonPerson.decode(Json.getJSONArray("persons").toString());
        ArrayList<Interesser> interessersList = JsonInteresser.decode(Json.getJSONArray("interessers").toString());

        Object[] obj = new Object[2];

        obj[0] = personList;
        obj[1] = interessersList;

        return obj;
    }
}
