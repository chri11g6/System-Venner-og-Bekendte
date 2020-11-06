package main.view.console.display;

import java.util.List;

import main.dto.iInteresser;
import main.dto.iPerson;

public class PrintTools {
	public static void printInteresserList(List<iInteresser> interessersList) {
		int maxSizeId = 2;
		int maxSizeInteresser = 10;

		maxSizeId = Math.max(maxSizeId, String.valueOf(interessersList.size()).length());

		for (int i = 0; i < interessersList.size(); i++) {
			maxSizeInteresser = Math.max(maxSizeInteresser, interessersList.get(i).getNavn().length());
		}

		StringBuilder header = new StringBuilder();

		header.append("ID");
		header.append(Tools.loopString(maxSizeId, " "));
		header.append("Interesser");

		System.out.println("");
		System.out.println(header.toString());
		System.out.println(Tools.loopString(maxSizeId + maxSizeInteresser, "-"));

		for (int i = 0; i < interessersList.size(); i++) {
			StringBuilder interesserText = new StringBuilder();
			interesserText.append(interessersList.get(i).getId());
			interesserText.append(Tools.loopString(maxSizeId - String.valueOf(i).length() + 2, " "));
			interesserText.append(interessersList.get(i).getNavn());
			System.out.println(interesserText.toString());
		}
		System.out.println("");
	}

	public static void printPersonList(List<iPerson> personsList) {
		int maxSizeForNavn = 7;
		int maxSizeId = 2;
		int maxSizeEfterNavn = 9;
		int maxSizeAlder = 5;
		int maxSizeTelefon = 7;
		int maxSizeEmail = 5;
		int addSpaceTo = 2;

		for (int i = 0; i < personsList.size(); i++) {
			iPerson person = personsList.get(i);
			maxSizeForNavn = Math.max(maxSizeForNavn, person.getForNavn().length());
			maxSizeEfterNavn = Math.max(maxSizeEfterNavn, person.getEfterNavn().length());
			maxSizeTelefon = Math.max(maxSizeTelefon, person.getTelefon().length());
			maxSizeEmail = Math.max(maxSizeEmail, person.getEmail().length());
			maxSizeAlder = Math.max(maxSizeAlder, String.valueOf(person.getBirthday().getAlder()).length());
		}

		maxSizeId = Math.max(maxSizeId, String.valueOf(personsList.size()).length());

		StringBuilder header = new StringBuilder();

		header.append("ID");
		header.append(Tools.loopString(maxSizeId - 2 + addSpaceTo, " "));
		header.append("Fornavn");
		header.append(Tools.loopString(maxSizeForNavn - 7 + addSpaceTo, " "));
		header.append("Efternavn");
		header.append(Tools.loopString(maxSizeEfterNavn - 9 + addSpaceTo, " "));
		header.append("Alder");
		header.append(Tools.loopString(maxSizeAlder - 5 + addSpaceTo, " "));
		header.append("Telefon");
		header.append(Tools.loopString(maxSizeTelefon - 7 + addSpaceTo, " "));
		header.append("Email");
		header.append(Tools.loopString(maxSizeEmail - 5 + addSpaceTo, " "));
		header.append("Interesser");

		System.out.println("");
		System.out.println(header.toString());
		System.out.println(Tools.loopString(header.length(), "-"));

		for (int i = 0; i < personsList.size(); i++) {
			iPerson person = personsList.get(i);
			StringBuilder personText = new StringBuilder();

			personText.append(i);
			personText.append(Tools.loopString(maxSizeId - String.valueOf(i).length() + addSpaceTo, " "));
			personText.append(person.getForNavn());
			personText.append(Tools.loopString(maxSizeForNavn - person.getForNavn().length() + addSpaceTo, " "));
			personText.append(person.getEfterNavn());
			personText.append(Tools.loopString(maxSizeEfterNavn - person.getEfterNavn().length() + addSpaceTo, " "));
			personText.append(person.getBirthday().getAlder());
			personText.append(Tools.loopString(maxSizeAlder - String.valueOf(person.getBirthday().getAlder()).length() + addSpaceTo, " "));
			personText.append(person.getTelefon());
			personText.append(
					Tools.loopString(maxSizeTelefon - String.valueOf(person.getTelefon()).length() + addSpaceTo, " "));
			personText.append(person.getEmail());
			personText.append(
					Tools.loopString(maxSizeEmail - String.valueOf(person.getEmail()).length() + addSpaceTo, " "));

			for (int j = 0; j < person.getPersonInteresserList().getInteresser().size(); j++) {
				personText.append(person.getPersonInteresserList().getInteresser().get(j).getNavn());
				if (j < person.getPersonInteresserList().getInteresser().size() - 1) {
					personText.append(", ");
				}
			}

			System.out.println(personText.toString());
		}
		System.out.println("");
	}
}
