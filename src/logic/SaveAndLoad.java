package logic;

import java.io.IOException;

import data.File;
import data.iFile;
import dto.dataType.FileData;

public class SaveAndLoad implements iSaveAndLoad {

	private iFile file = new File();

	@Override
	public void saveInteressersAsJSON(String path) throws IOException {
		FileData data = new FileData();

		data.path = path;
		data.interessers = Global.interesserList;
		file.saveInteressersAsJSON(data);
	}

	@Override
	public void savePersonsAsJSON(String path) throws IOException {
		FileData data = new FileData();

		data.path = path;
		data.persons = Global.personList;
		file.savePersonsAsJSON(data);
	}

	@Override
	public void saveAllAsJSON(String path) throws IOException {
		FileData data = new FileData();

		data.path = path;
		data.persons = Global.personList;
		data.interessers = Global.interesserList;
		file.saveAllAsJSON(data);
	}

	@Override
	public void loadInteressersAsJSON(String path) throws IOException {
		Global.interesserList.clear();
		Global.interesserList.addAll(file.loadInteressersAsJSON(path));

	}

	@Override
	public void loadPersonsAsJSON(String path) throws IOException {
		Global.personList.clear();
		Global.personList.addAll(file.loadPersonsAsJSON(path));

	}

	@Override
	public void loadAllAsJSON(String path) throws IOException {
		FileData data = file.loadAllAsJSON(path);

		Global.personList.clear();
		Global.personList.addAll(data.persons);
		Global.interesserList.clear();
		Global.interesserList.addAll(data.interessers);
	}

}
