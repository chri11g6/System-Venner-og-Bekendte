package main.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person implements iPerson {
	private int id;
	private static int counter = 0;
	private String forNavn;
	private String efterNavn;
	private String telefon;
	private String email;

	private iBirthday birthday = new Birthday();

	private List<iInteresser> interesser = new ArrayList<iInteresser>();

	public Person() {
		this.id = counter;
		counter++;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getEmail() {
		if (this.email != null) {
			return this.email;
		} else {
			return "";
		}
	}

	@Override
	public void setEmail(String email) {
		if (email.isEmpty()) {
			this.email = "";
			return;
		}

		Pattern p = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}");
		Matcher m = p.matcher(email);

		if (m.matches()) {
			this.email = email;
		} else {
			throw new IllegalArgumentException("Email er ikke gyldig");
		}
	}

	@Override
	public String getTelefon() {
		if (this.telefon != null) {
			return this.telefon;
		} else {
			return "";
		}
	}

	@Override
	public void setTelefon(String telefon) {
		if (telefon.isEmpty()) {
			this.telefon = "";
			return;
		}

		Pattern p = Pattern.compile("(\\+?\\d{1,6})?(\\d{2} ?){4}");
		Matcher m = p.matcher(telefon);

		if (m.matches()) {
			this.telefon = telefon;
		} else {
			throw new IllegalArgumentException("Telefon nummer er ikke gyldig");
		}
	}

	@Override
	public List<iInteresser> getInteresser() {
		return interesser;
	}

	@Override
	public String getForNavn() {
		return forNavn;
	}

	@Override
	public void setForNavn(String forNavn) {
		this.forNavn = forNavn;
	}

	@Override
	public String getEfterNavn() {
		return efterNavn;
	}

	@Override
	public void setEfterNavn(String efterNavn) {
		this.efterNavn = efterNavn;
	}

	@Override
	public iBirthday getBirthday() {
		return birthday;
	}
}
