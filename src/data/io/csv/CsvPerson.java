package data.io.csv;

import java.util.ArrayList;
import java.util.List;

import dto.Interesser;
import dto.Person;

public class CsvPerson {
	private static char tegnSpliter = ',';

	public static String encode(List<Person> datas) {
		StringBuilder builder = new StringBuilder();

		builder.append("forNavn");
		builder.append(tegnSpliter);
		builder.append("efterNavn");
		builder.append(tegnSpliter);
		builder.append("alder");
		builder.append(tegnSpliter);
		builder.append("Telefon");
		builder.append(tegnSpliter);
		builder.append("Email");
		builder.append("\n");

		for (int i = 0; i < datas.size(); i++) {
			Person data = datas.get(i);
			builder.append(data.forNavn);
			builder.append(tegnSpliter);
			builder.append(data.efterNavn);
			builder.append(tegnSpliter);
			builder.append(data.alder);
			builder.append(tegnSpliter);
			builder.append(data.getTelefon());
			builder.append(tegnSpliter);
			builder.append(data.getEmail());

			for (int j = 0; j < data.interesser.size(); j++) {
				builder.append(data.forNavn);
				if (j < data.interesser.size() - 1) {
					builder.append(tegnSpliter);
				}
			}

			builder.append("\n");
		}

		return builder.toString();
	}

	public static List<Person> decode(String text) {
		String[] lings = text.split("\n");

		List<Person> personList = new ArrayList<Person>();

		for (int i = 1; i < lings.length; i++) {
			try {
				String[] data = lings[i].split(";");
				Person person = new Person();

				person.forNavn = data[0];
				person.efterNavn = data[1];
				person.alder = Integer.parseInt(data[2]);
				person.setTelefon(data[3]);
				person.setEmail(data[4]);

				for (int j = 5; j < data.length; j++) {
					person.interesser.add(new Interesser(data[j]));
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
