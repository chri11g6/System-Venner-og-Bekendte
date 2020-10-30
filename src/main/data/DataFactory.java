package main.data;

public class DataFactory {
	private static iPersonData personData = null;
	private static iInteresserData interesserData = null;

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
