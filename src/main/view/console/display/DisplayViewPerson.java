package main.view.console.display;

import main.logic.Global;

public class DisplayViewPerson implements iDisplay {

	@Override
	public void printHelp() {
		defaultPrintHelp();
		System.out.println("'view' For at se talben");
		System.out.println("'edit interesser' For at ret, tilføjer eller slet interesser");
		System.out.println("'set' '[parmeter]' Hvilken del vil du ænder?");
		System.out.println("[parmeter]:");
		System.out.println("\t'fornavn'");
		System.out.println("\t'efternavn'");
		System.out.println("\t'fødselsdage'");
		System.out.println("\t'telefon'");
		System.out.println("\t'email'");
		System.out.println("'get' '[parmeter]' Hvilken del vil du hente?");
		System.out.println("[parmeter]:");
		System.out.println("\t'fornavn'");
		System.out.println("\t'efternavn'");
		System.out.println("\t'alder'");
		System.out.println("\t'telefon'");
		System.out.println("\t'email'");
	}

	@Override
	public void printView() {
		int maxSizeForNavn = 7;
		int maxSizeEfterNavn = 9;
		int maxSizeAlder = 5;
		int maxSizeTelefon = 7;
		int maxSizeEmail = 5;
		int addSpaceTo = 2;

		maxSizeForNavn = Math.max(maxSizeForNavn, Global.personHolder.getForNavn().length());
		maxSizeEfterNavn = Math.max(maxSizeEfterNavn, Global.personHolder.getEfterNavn().length());
		maxSizeTelefon = Math.max(maxSizeTelefon, Global.personHolder.getTelefon().length());
		maxSizeEmail = Math.max(maxSizeEmail, Global.personHolder.getEmail().length());
		maxSizeAlder = Math.max(maxSizeAlder, String.valueOf(Global.personHolder.getBirthday().getAlder()).length());

		StringBuilder header = new StringBuilder();

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

		StringBuilder personText = new StringBuilder();

		personText.append(Global.personHolder.getForNavn());
		personText.append(Tools.loopString(maxSizeForNavn - Global.personHolder.getForNavn().length() + addSpaceTo, " "));
		personText.append(Global.personHolder.getEfterNavn());
		personText
				.append(Tools.loopString(maxSizeEfterNavn - Global.personHolder.getEfterNavn().length() + addSpaceTo, " "));
		personText.append(Global.personHolder.getBirthday().getAlder());
		personText.append(
				Tools.loopString(maxSizeAlder - String.valueOf(Global.personHolder.getBirthday().getAlder()).length() + addSpaceTo, " "));
		personText.append(Global.personHolder.getTelefon());
		personText.append(Tools.loopString(
				maxSizeTelefon - String.valueOf(Global.personHolder.getTelefon()).length() + addSpaceTo, " "));
		personText.append(Global.personHolder.getEmail());
		personText.append(Tools
				.loopString(maxSizeEmail - String.valueOf(Global.personHolder.getEmail()).length() + addSpaceTo, " "));

		for (int j = 0; j < Global.personHolder.getInteresser().size(); j++) {
			personText.append(Global.personHolder.getInteresser().get(j).getNavn());
			if (j < Global.personHolder.getInteresser().size() - 1) {
				personText.append(", ");
			}
		}

		System.out.println(personText.toString());
		System.out.println("");
	}

}
