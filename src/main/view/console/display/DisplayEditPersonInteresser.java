package main.view.console.display;

import main.logic.Global;

public class DisplayEditPersonInteresser implements iDisplay {

	@Override
	public void printHelp() {
		defaultPrintHelp();
		System.out.println("'view' For at se person interesser talben");
		System.out.println("'view global' For at se den global interesser talben");
		System.out.println("'remove [id]' For at se slet en interesser fra person");
		System.out.println("'add [id]' For at se tilføjer en interesser til person fra global interesser talben");
		System.out.println(
				"'add new' For at se tilføjer en interesser til person og\n\ttilføjer en ny interesser til global interesser talben");
	}

	@Override
	public void printView() {
		int maxSizeId = 2;
		int maxSizeInteresser = 10;

		maxSizeId = Math.max(maxSizeId, String.valueOf(Global.getPersonHolder().getPersonInteresserList().getInteresser().size()).length());

		for (int i = 0; i < Global.getPersonHolder().getPersonInteresserList().getInteresser().size(); i++) {
			maxSizeInteresser = Math.max(maxSizeInteresser, Global.getPersonHolder().getPersonInteresserList().getInteresser().get(i).getNavn().length());
		}

		StringBuilder header = new StringBuilder();

		header.append("ID");
		header.append(Tools.loopString(maxSizeId, " "));
		header.append("Interesser");

		System.out.println("");
		System.out.println(header.toString());
		System.out.println(Tools.loopString(maxSizeId + maxSizeInteresser, "-"));

		for (int i = 0; i < Global.getPersonHolder().getPersonInteresserList().getInteresser().size(); i++) {
			StringBuilder interesserText = new StringBuilder();
			interesserText.append(i);
			interesserText.append(Tools.loopString(maxSizeId - String.valueOf(i).length() + 2, " "));
			interesserText.append(Global.getPersonHolder().getPersonInteresserList().getInteresser().get(i).getNavn());
			System.out.println(interesserText.toString());
		}
		System.out.println("");
	}

}
