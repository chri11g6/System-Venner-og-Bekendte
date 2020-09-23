package data.io.json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.dataType.Person;

public class JsonPerson {

    public static String encodeToString(ArrayList<Person> persons) {
        return encode(persons).toString();
    }

    public static JSONArray encode(ArrayList<Person> persons) {
        
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
    
            JSONObject personJson = new JSONObject();
            personJson.put("forNavn", person.forNavn);
            personJson.put("efterNavn", person.efterNavn);
            personJson.put("alder", person.alder);
            personJson.put("Telefon", person.getTelefon());
            personJson.put("Email", person.getEmail());
            JSONArray interesserArray = new JSONArray();
    
            for (int j = 0; j < person.interesser.size(); j++) {
                interesserArray.put(person.interesser.get(j).navn);
            }
    
            personJson.put("interesser", interesserArray);
            jsonArray.put(personJson);
        }


        return jsonArray;
    }

    public static ArrayList<Person> decode(String data) {
        JSONArray personsJson = new JSONArray(data);
        ArrayList<Person> personList = new ArrayList<Person>();

        for (int i = 0; i < personsJson.length(); i++) {
            JSONObject personJson = personsJson.getJSONObject(i);
            Person person = new Person();
            person.forNavn = personJson.getString("forNavn");
            person.efterNavn = personJson.getString("efterNavn");
            person.alder= personJson.getInt("alder");
            person.setTelefon(personJson.getString("Telefon"));
            person.setEmail(personJson.getString("Email"));

            personList.add(person);
        }

        return personList;
    }
}
