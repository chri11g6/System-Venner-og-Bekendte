package view.gui.page.overView;

import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import view.gui.JavaFXTools;
import view.gui.page.iPage;

public class OverView implements iPage {
	private AnchorPane page = new AnchorPane();

	private TabPane tabPane = new TabPane();

	private Tab personTab = new PersonTab().load();
	private Tab interesserTab = new InteresserTab().load();

	@Override
	public AnchorPane load() {
		JavaFXTools.setAnchor(tabPane);

		tabPane.getTabs().addAll(personTab, interesserTab);
		tabPane.setSide(Side.BOTTOM);

		tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

		page.getChildren().add(tabPane);

		return page;
	}
}
