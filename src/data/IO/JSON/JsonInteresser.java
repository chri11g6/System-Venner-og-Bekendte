package data.io.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import dto.dataType.Interesser;

public class JsonInteresser {

	public static String encodeToString(List<Interesser> interessers) {
		return encode(interessers).toString();
	}

	public static JSONArray encode(List<Interesser> datas) {
		JSONArray jsonArray = new JSONArray();

		for (int i = 0; i < datas.size(); i++) {
			jsonArray.put(datas.get(i).navn);

		}
		return jsonArray;
	}

	public static List<Interesser> decode(String data) {
		JSONArray interesserJson = new JSONArray(data);
		List<Interesser> interesserList = new ArrayList<Interesser>();

		for (int i = 0; i < interesserJson.length(); i++) {
			interesserList.add(new Interesser(interesserJson.getString(i)));
		}

		return interesserList;

	}

}
