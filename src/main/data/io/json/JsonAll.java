// https://github.com/stleary/JSON-java

package main.data.io.json;

import java.util.List;

import org.json.JSONObject;

import main.dto.FileData;
import main.dto.iInteresser;
import main.dto.iPerson;

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

		List<iPerson> personList = JsonPerson.decode(Json.getJSONArray("persons").toString());
		List<iInteresser> interessersList = JsonInteresser.decode(Json.getJSONArray("interessers").toString());

		FileData data = new FileData();

		data.persons = personList;
		data.interessers = interessersList;

		return data;
	}
}
