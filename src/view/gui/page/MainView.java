package view.gui.page;

import javafx.scene.layout.AnchorPane;

import view.gui.JavaFXTools;
import view.gui.page.overView.OverView;
import view.gui.page.editAndCreatePerson.EditAndCreatePerson;
import view.gui.page.viewPerson.ViewPerson;

public class MainView implements iPage {

	private AnchorPane mainPage = new AnchorPane();

	private AnchorPane overView = new OverView().load();
	private AnchorPane viewPerson = new ViewPerson().load();
	private AnchorPane editAndCreatePerson = new EditAndCreatePerson().load();

	@Override
	public AnchorPane load() {
		
		JavaFXTools.setAnchor(overView);
		JavaFXTools.setAnchor(viewPerson);
		JavaFXTools.setAnchor(editAndCreatePerson);

		viewPerson.setVisible(false);
		editAndCreatePerson.setVisible(false);

		mainPage.getChildren().addAll(overView, viewPerson, editAndCreatePerson);

		return mainPage;
	}
	
}
