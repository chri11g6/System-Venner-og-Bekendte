package main.data.io.csv;

import java.util.ArrayList;
import java.util.List;

import main.dto.Interesser;
import main.dto.Person;
import main.dto.iPerson;

public class CsvPerson {
	private static char tegnSpliter = ',';

	public static String encode(List<iPerson> datas) {
		StringBuilder builder = new StringBuilder();

		builder.append("forNavn");
		builder.append(tegnSpliter);
		builder.append("efterNavn");
		builder.append(tegnSpliter);
		builder.append("fødselsdage");
		builder.append(tegnSpliter);
		builder.append("Telefon");
		builder.append(tegnSpliter);
		builder.append("Email");
		builder.append("\n");

		for (int i = 0; i < datas.size(); i++) {
			iPerson data = datas.get(i);
			builder.append(data.getForNavn());
			builder.append(tegnSpliter);
			builder.append(data.getEfterNavn());
			builder.append(tegnSpliter);
			builder.append(data.getBirthday().getBirthdays());
			builder.append(tegnSpliter);
			builder.append(data.getTelefon());
			builder.append(tegnSpliter);
			builder.append(data.getEmail());

			for (int j = 0; j < data.getPersonInteresserList().getInteresser().size(); j++) {
				builder.append(data.getForNavn());
				if (j < data.getPersonInteresserList().getInteresser().size() - 1) {
					builder.append(tegnSpliter);
				}
			}

			builder.append("\n");
		}

		return builder.toString();
	}

	public static List<iPerson> decode(String text) {
		String[] lings = text.split("\n");

		List<iPerson> personList = new ArrayList<iPerson>();

		for (int i = 1; i < lings.length; i++) {
			try {
				String[] data = lings[i].split(";");
				iPerson person = new Person();

				person.setForNavn(data[0]);
				person.setEfterNavn(data[1]);
				person.getBirthday().setBirthdays(data[2]);
				person.setTelefon(data[3]);
				person.setEmail(data[4]);

				for (int j = 5; j < data.length; j++) {
					person.getPersonInteresserList().getInteresser().add(new Interesser(data[j]));
				}

				personList.add(person);

			} catch (Exception e) {
				System.out.println("Kunne ikke opret person fordi:");
				System.out.println(e.getMessage());
			}
		}

		return personList;
	}
}
