package view.gui.page.overView;

import javafx.scene.control.Tab;

public class InteresserTab implements iTab {
	private Tab tab = new Tab();

	public Tab load(){
		tab.setText("Interesser");

		return tab;
	}
}
