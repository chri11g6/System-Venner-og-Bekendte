package main.data;

public class HoldData {
	private static iPersonData personData = new PersonData();
	private static iInteresserData interesserData = new InteresserData();

	public static iPersonData getPersonData(){
		return personData;
	}

	public static iInteresserData getInteresserData(){
		return interesserData;
	}

}
