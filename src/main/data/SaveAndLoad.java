package main.data;

import java.io.IOException;

import main.dto.FileData;

public class SaveAndLoad implements iSaveAndLoad {

	private iFile file = new File();

	@Override
	public void saveInteressersAsJSON(String path) throws IOException {
		FileData data = new FileData();

		data.path = path;
		data.interessers = DataFactory.getInteresserData().getAllAsList();
		file.saveInteressersAsJSON(data);
	}

	@Override
	public void savePersonsAsJSON(String path) throws IOException {
		FileData data = new FileData();

		data.path = path;
		data.persons = DataFactory.getPersonData().getAllAsList();
		file.savePersonsAsJSON(data);
	}

	@Override
	public void saveAllAsJSON(String path) throws IOException {
		FileData data = new FileData();

		data.path = path;
		data.persons = DataFactory.getPersonData().getAllAsList();
		data.interessers = DataFactory.getInteresserData().getAllAsList();
		file.saveAllAsJSON(data);
	}

	@Override
	public void loadInteressersAsJSON(String path) throws IOException {
		DataFactory.getInteresserData().addFresh(file.loadInteressersAsJSON(path));
	}

	@Override
	public void loadPersonsAsJSON(String path) throws IOException {
		DataFactory.getPersonData().addFresh(file.loadPersonsAsJSON(path));
	}

	@Override
	public void loadAllAsJSON(String path) throws IOException {
		FileData data = file.loadAllAsJSON(path);

		DataFactory.getInteresserData().addFresh(data.interessers);
		DataFactory.getPersonData().addFresh(data.persons);
	}

}
