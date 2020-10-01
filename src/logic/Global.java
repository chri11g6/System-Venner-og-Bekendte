package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import dto.dataType.Interesser;
import dto.dataType.Person;

public class Global {
	public static List<Person> personList = new ArrayList<Person>();
	public static List<Interesser> interesserList = new ArrayList<Interesser>();

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
