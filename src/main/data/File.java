package main.data;

import java.io.IOException;
import java.util.List;

import main.data.io.FileIO;
import main.data.io.json.JsonAll;
import main.data.io.json.JsonInteresser;
import main.data.io.json.JsonPerson;
import main.dto.FileData;
import main.dto.iInteresser;
import main.dto.iPerson;

public class File implements iFile {
	@Override
	public void saveAllAsJSON(FileData data) throws IOException {
		String jsonText = JsonAll.encodeToString(data);
		FileIO.write(jsonText, data.path);
	}

	@Override
	public void saveInteressersAsJSON(FileData data) throws IOException {
		String jsonText = JsonInteresser.encodeToString(data.interessers);
		FileIO.write(jsonText, data.path);
	}

	@Override
	public void savePersonsAsJSON(FileData data) throws IOException {
		String jsonText = JsonPerson.encodeToString(data.persons);
		FileIO.write(jsonText, data.path);
	}

	@Override
	public List<iInteresser> loadInteressersAsJSON(String path) throws IOException {
		String data = FileIO.read(path);
		return JsonInteresser.decode(data);
	}

	@Override
	public List<iPerson> loadPersonsAsJSON(String path) throws IOException {
		String data = FileIO.read(path);
		return JsonPerson.decode(data);
	}

	@Override
	public FileData loadAllAsJSON(String path) throws IOException {
		String data = FileIO.read(path);
		return JsonAll.decode(data);
	}

}
