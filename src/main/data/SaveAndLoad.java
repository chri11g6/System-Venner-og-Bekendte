package main.data;

import java.io.IOException;

import main.dto.FileData;

public class SaveAndLoad implements iSaveAndLoad {

	private iFile file = new File();

	@Override
	public void saveInteressersAsJSON(String path) throws IOException {
		FileData data = new FileData();

		data.path = path;
		data.interessers = HoldData.getInteresserData().getAllAsList();
		file.saveInteressersAsJSON(data);
	}

	@Override
	public void savePersonsAsJSON(String path) throws IOException {
		FileData data = new FileData();

		data.path = path;
		data.persons = HoldData.getPersonData().getAllAsList();
		file.savePersonsAsJSON(data);
	}

	@Override
	public void saveAllAsJSON(String path) throws IOException {
		FileData data = new FileData();

		data.path = path;
		data.persons = HoldData.getPersonData().getAllAsList();
		data.interessers = HoldData.getInteresserData().getAllAsList();
		file.saveAllAsJSON(data);
	}

	@Override
	public void loadInteressersAsJSON(String path) throws IOException {
		HoldData.getInteresserData().addFresh(file.loadInteressersAsJSON(path));
	}

	@Override
	public void loadPersonsAsJSON(String path) throws IOException {
		HoldData.getPersonData().addFresh(file.loadPersonsAsJSON(path));
	}

	@Override
	public void loadAllAsJSON(String path) throws IOException {
		FileData data = file.loadAllAsJSON(path);

		HoldData.getInteresserData().addFresh(data.interessers);
		HoldData.getPersonData().addFresh(data.persons);
	}

}
