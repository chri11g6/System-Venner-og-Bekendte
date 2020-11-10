package main.logic;

import java.io.File;
import java.io.IOException;

import main.data.SaveAndLoad;
import main.data.iSaveAndLoad;

class SaveAndLoadLogic implements iSaveAndLoadLogic {

	private iSaveAndLoad saveAndLoad = new SaveAndLoad();

	@Override
	public void saveInteressersAsJSON(String path) throws IOException {
		saveAndLoad.saveInteressersAsJSON(path);
	}

	@Override
	public void savePersonsAsJSON(String path) throws IOException {
		saveAndLoad.savePersonsAsJSON(path);
	}

	@Override
	public void saveAllAsJSON(String path) throws IOException {
		saveAndLoad.saveAllAsJSON(path);
	}

	@Override
	public void loadInteressersAsJSON(String path) throws IOException {
		saveAndLoad.loadInteressersAsJSON(path);
	}

	@Override
	public void loadPersonsAsJSON(String path) throws IOException {
		saveAndLoad.loadPersonsAsJSON(path);
	}

	@Override
	public void loadAllAsJSON(String path) throws IOException {
		saveAndLoad.loadAllAsJSON(path);
	}

	@Override
	public void saveInteressersAsJSON(File filePath) throws IOException {
		saveAndLoad.saveInteressersAsJSON(filePath);
	}

	@Override
	public void savePersonsAsJSON(File filePath) throws IOException {
		saveAndLoad.savePersonsAsJSON(filePath);
	}

	@Override
	public void saveAllAsJSON(File filePath) throws IOException {
		saveAndLoad.saveAllAsJSON(filePath);
	}

	@Override
	public void loadInteressersAsJSON(File filePath) throws IOException {
		saveAndLoad.loadInteressersAsJSON(filePath);
	}

	@Override
	public void loadPersonsAsJSON(File filePath) throws IOException {
		saveAndLoad.loadPersonsAsJSON(filePath);
	}

	@Override
	public void loadAllAsJSON(File filePath) throws IOException {
		saveAndLoad.loadAllAsJSON(filePath);
	}

	@Override
	public void saveAllFromGlobal() {
		try {
			saveAndLoad.saveAllAsJSON(LogicFactory.getGlobal().getFilePathHolder());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void loadAllFromGlobal() {
		try {
			saveAndLoad.loadAllAsJSON(LogicFactory.getGlobal().getFilePathHolder());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	

}
