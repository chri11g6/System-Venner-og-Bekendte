package main.view.fxml.window.search;

public class SearchFilter {
	public enum Operators {
		OR, AND, NOT
	}

	public Operators type;
	public String permeter;
	public String keyword;
	public String tegn;
}
