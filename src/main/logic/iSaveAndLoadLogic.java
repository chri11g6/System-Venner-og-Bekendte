package main.logic;

import main.data.iSaveAndLoad;

public interface iSaveAndLoadLogic extends iSaveAndLoad {
	public void saveAllFromGlobal();
	public void loadAllFromGlobal();
}
