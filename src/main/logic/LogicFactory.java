package main.logic;

public class LogicFactory {
	private static iSaveAndLoadLogic saveAndLoadLogic = null;
	private static iPersonLogicData personLogicData = null;
	private static iInteresserLogicData interesserLogicData = null;
	private static iGlobal global = null;

	public static iGlobal getGlobal() {
		if(global == null){
			global = new Global();
		}

		return global;
	}

	public static iSaveAndLoadLogic getSaveAndLoadLogic() {
		if(saveAndLoadLogic == null){
			saveAndLoadLogic = new SaveAndLoadLogic();
		}

		return saveAndLoadLogic;
	}

	public static iPersonLogicData getPersonLogicData() {
		if(personLogicData == null){
			personLogicData = new PersonLogicData();
		}

		return personLogicData;
	}

	public static iInteresserLogicData getInteresserLogicData() {
		if(interesserLogicData == null){
			interesserLogicData = new InteresserLogicData();
		}

		return interesserLogicData;
	}
}
