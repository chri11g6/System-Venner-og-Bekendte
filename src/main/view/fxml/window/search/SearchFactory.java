package main.view.fxml.window.search;

public class SearchFactory {
	private static iSearch search = null;

	public static iSearch getSearch(){
		if(search == null){
			search = new Search();
		}
		
		return search;
	}
}
