package main.view;

import main.view.console.page.MenuModul;
import main.view.fxml.FxmlGUIApp;
import main.view.gui.GuiApp;

public class ViewFactory {
	private static iView menuModul = null;
	private static iView guiApp = null;
	private static iView fxmlApp = null;

	public static iView getConsole(){
		if(menuModul == null){
			menuModul = new MenuModul();
		}

		return menuModul;
	}

	public static iView getGUI(){
		if(guiApp == null){
			guiApp = new GuiApp();
		}
		return guiApp;
	}

	public static iView getGUIFxml(){
		if(fxmlApp == null){
			fxmlApp = new FxmlGUIApp();
		}
		return fxmlApp;
	}
}
