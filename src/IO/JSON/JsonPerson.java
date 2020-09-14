package IO.JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import DataType.Person;

public class JsonPerson {

    public static String encode(final Person[] persons) {
        JSONObject json = new JSONObject();

        JSONArray arr = new JSONArray();
        
        for (int i = 0; i < persons.length; i++) {
            Person person = persons[i];
            JSONObject item = new JSONObject();

            item.put("forNavn", person.forNavn);
            item.put("efterNavn", person.efterNavn);
            item.put("alder", person.alder);
            item.put("telefon", person.getTelefon());
            item.put("email", person.getEmail());

            arr.add(item);
        }

        json.put("persons", arr);

        System.out.println(json.toString());


        return null;
    }

    public static void decode(final String data) {
        // TODO Auto-generated method stub

    }
}
