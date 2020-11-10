package main.view;

import main.view.fxml.FxmlGUIApp;

public class ViewFactory {
	private static iView fxmlApp = null;

	public static iView getGUIFxml(){
		if(fxmlApp == null){
			fxmlApp = new FxmlGUIApp();
		}
		return fxmlApp;
	}
}
