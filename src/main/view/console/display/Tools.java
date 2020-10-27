package main.view.console.display;

public class Tools {
	public static String loopString(int tal, String str) {
		StringBuilder text = new StringBuilder();

		for (int i = 0; i < tal; i++) {
			text.append(str);
		}

		return text.toString();
	}
}
