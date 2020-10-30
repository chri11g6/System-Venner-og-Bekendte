package main.data.io.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import main.dto.Interesser;
import main.dto.iInteresser;

public class JsonInteresser {

	public static String encodeToString(List<iInteresser> interessers) {
		return encode(interessers).toString();
	}

	public static JSONArray encode(List<iInteresser> datas) {
		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < datas.size(); i++) {
			jsonArray.put(datas.get(i).getNavn());

		}
		return jsonArray;
	}

	public static List<iInteresser> decode(String data) {
		JSONArray interesserJson = new JSONArray(data);
		List<iInteresser> interesserList = new ArrayList<iInteresser>();

		for (int i = 0; i < interesserJson.length(); i++) {
			interesserList.add(new Interesser(interesserJson.getString(i)));
		}

		return interesserList;

	}

}
