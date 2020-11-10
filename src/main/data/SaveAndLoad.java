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

	@Override
	public void saveInteressersAsJSON(java.io.File filePath) throws IOException {
		saveInteressersAsJSON(filePath.getAbsolutePath());
	}

	@Override
	public void savePersonsAsJSON(java.io.File filePath) throws IOException {
		savePersonsAsJSON(filePath.getAbsolutePath());
	}

	@Override
	public void saveAllAsJSON(java.io.File filePath) throws IOException {
		saveAllAsJSON(filePath.getAbsolutePath());
	}

	@Override
	public void loadInteressersAsJSON(java.io.File filePath) throws IOException {
		loadInteressersAsJSON(filePath.getAbsolutePath());
	}

	@Override
	public void loadPersonsAsJSON(java.io.File filePath) throws IOException {
		loadPersonsAsJSON(filePath.getAbsolutePath());
	}

	@Override
	public void loadAllAsJSON(java.io.File filePath) throws IOException {
		loadAllAsJSON(filePath.getAbsolutePath());
	}

}
