package data;

import java.io.IOException;
import java.util.List;

import data.io.FileIO;
import data.io.json.JsonAll;
import data.io.json.JsonInteresser;
import data.io.json.JsonPerson;
import dto.dataType.FileData;
import dto.dataType.Interesser;
import dto.dataType.Person;

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
	public List<Interesser> loadInteressersAsJSON(String path) throws IOException {
		String data = FileIO.read(path);
		return JsonInteresser.decode(data);
	}

	@Override
	public List<Person> loadPersonsAsJSON(String path) throws IOException {
		String data = FileIO.read(path);
		return JsonPerson.decode(data);
	}

	@Override
	public FileData loadAllAsJSON(String path) throws IOException {
		String data = FileIO.read(path);
		return JsonAll.decode(data);
	}

}
