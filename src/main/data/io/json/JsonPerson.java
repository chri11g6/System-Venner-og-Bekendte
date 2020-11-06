package main.data.io.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import main.dto.Address;
import main.dto.Person;
import main.dto.iAddress;
import main.dto.iPerson;

public class JsonPerson {

	public static String encodeToString(List<iPerson> persons) {
		return encode(persons).toString();
	}

	public static JSONArray encode(List<iPerson> persons) {

		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < persons.size(); i++) {
			iPerson person = persons.get(i);

			JSONObject personJson = new JSONObject();
			personJson.put("forNavn", person.getForNavn());
			personJson.put("efterNavn", person.getEfterNavn());
			personJson.put("fødselsdage", person.getBirthday().getBirthdays());
			personJson.put("telefon", person.getTelefon());
			personJson.put("email", person.getEmail());
			personJson.put("address", fromAddressToJson(person.getAddress()));

			JSONArray interesserArray = new JSONArray();

			for (int j = 0; j < person.getInteresser().size(); j++) {
				interesserArray.put(person.getInteresser().get(j).getNavn());
			}

			personJson.put("interesser", interesserArray);
			jsonArray.put(personJson);
		}

		return jsonArray;
	}

	private static JSONObject fromAddressToJson(iAddress address){
		JSONObject addressJson = new JSONObject();

		addressJson.put("gade", address.getGade());
		addressJson.put("nr", address.getNr());
		addressJson.put("by", address.getBy());
		addressJson.put("postNr", address.getPostNr());
		addressJson.put("land", address.getLand());

		return addressJson;
	}

	private static iAddress fromJsonToAddress(JSONObject json){
		iAddress address = new Address();

		address.setBy(json.getString("by"));
		address.setGade(json.getString("gade"));
		address.setNr(json.getString("nr"));
		address.setLand(json.getString("land"));
		address.setPostNr(json.getString("postNr"));

		return address;
	}

	public static List<iPerson> decode(String data) {
		JSONArray personsJson = new JSONArray(data);
		List<iPerson> personList = new ArrayList<iPerson>();

		for (int i = 0; i < personsJson.length(); i++) {
			JSONObject personJson = personsJson.getJSONObject(i);
			Person person = new Person();
			person.setForNavn(personJson.getString("forNavn"));
			person.setEfterNavn(personJson.getString("efterNavn"));
			person.getBirthday().setBirthdays(personJson.getString("fødselsdage"));
			person.setTelefon(personJson.getString("telefon"));
			person.setEmail(personJson.getString("email"));
			person.setAddress(fromJsonToAddress(personJson.getJSONObject("address")));

			personList.add(person);
		}

		return personList;
	}
}
