package view.gui;

import javafx.scene.layout.VBox;
import view.gui.menuComponent.MenuBarComponent;
import view.gui.page.iPage;
import view.gui.page.MainView;

public class WindowsPage {
	private VBox mainPage = new VBox();
	private MenuBarComponent menuBar = new MenuBarComponent();

	private iPage mainView = new MainView();

	public VBox load(){
		mainPage.setPrefWidth(640);
		mainPage.setPrefHeight(400);

		mainPage.getChildren().addAll(menuBar.load(), mainView.load());

		return mainPage;
	}
}
