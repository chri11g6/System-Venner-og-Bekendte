package main.logic;

import java.io.IOException;

import main.data.SaveAndLoad;
import main.data.iSaveAndLoad;

public class SaveAndLoadLogic implements iSaveAndLoadLogic {

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
	

}
