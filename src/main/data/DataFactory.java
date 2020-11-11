package main.data;

public class DataFactory {
	private static iPersonData personData = null;
	private static iInteresserData interesserData = null;
	private static iSaveAndLoad saveAndLoad = null;

	public static iSaveAndLoad getSaveAndLoad(){
		if(saveAndLoad == null) {
			saveAndLoad = new SaveAndLoad();
		}

		return saveAndLoad;
	}

	public static iPersonData getPersonData(){
		if(personData == null) {
			personData = new PersonData();
		}

		return personData;
	}

	public static iInteresserData getInteresserData(){
		if (interesserData == null) {
			interesserData = new InteresserData();
		}

		return interesserData;
	}

}
