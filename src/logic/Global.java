package logic;

import java.util.Stack;

import dto.Person;

public class Global {

	public static iPesonLogicData personList = new PesonLogicData();
	public static iInteresserLogicData interesserList = new InteresserLogicData();

	public static Person personHolder;

	public static Stack<String> sti = new Stack<String>();

	public static String getSti() {
		StringBuilder sti = new StringBuilder();

		for (int i = 0; i < Global.sti.size(); i++) {
			sti.append(Global.sti.get(i));
			if (i < Global.sti.size() - 1) {
				sti.append("> ");
			}
		}

		return sti.toString();
	}
}
