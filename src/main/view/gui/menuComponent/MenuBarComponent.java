package main.view.gui.menuComponent;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MenuBarComponent {
	private MenuBar menuBar = new MenuBar();

	public MenuBar load() {

		menuBar.getMenus().add(createMenuFile());

		return menuBar;
	}

	private Menu createMenuFile(){
		Menu menu = new Menu();

		menu.setText("File");
		menu.getItems().add(createMenuItem("New"));
		menu.getItems().add(createMenuItem("Open"));
		menu.getItems().add(new SeparatorMenuItem());
		menu.getItems().add(createMenuItem("Save"));
		menu.getItems().add(createMenuItem("Save as"));

		return menu;
	}

	private MenuItem createMenuItem(String text){
		MenuItem menuItem = new MenuItem();

		menuItem.setText(text);

		return menuItem;
	}
}
