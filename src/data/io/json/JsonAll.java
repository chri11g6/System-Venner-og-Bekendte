// https://github.com/stleary/JSON-java

package data.io.json;

import java.util.List;

import org.json.JSONObject;

import dto.dataType.FileData;
import dto.dataType.Interesser;
import dto.dataType.Person;

public class JsonAll {
	public static String encodeToString(FileData jsonDatas) {
		return encode(jsonDatas).toString();
	}

	public static JSONObject encode(FileData jsonDatas) {
		JSONObject json = new JSONObject();

		json.put("persons", JsonPerson.encode(jsonDatas.persons));
		json.put("interessers", JsonInteresser.encode(jsonDatas.interessers));

		return json;
	}

	public static FileData decode(String jsonData) {
		JSONObject Json = new JSONObject(jsonData);

		List<Person> personList = JsonPerson.decode(Json.getJSONArray("persons").toString());
		List<Interesser> interessersList = JsonInteresser.decode(Json.getJSONArray("interessers").toString());

		FileData data = new FileData();

		data.persons = personList;
		data.interessers = interessersList;

		return data;
	}
}
