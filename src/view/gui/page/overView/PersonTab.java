package view.gui.page.overView;

import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import view.gui.JavaFXTools;

public class PersonTab implements iTab {
	private Tab tab = new Tab();

	private AnchorPane page = new AnchorPane();

	private TableView table = new TableView<>();

	public Tab load(){
		
		JavaFXTools.setAnchor(table, 45d, 10d, 10d, 10d);

		page.getChildren().add(table);
		
		
		tab.setText("Person");
		tab.setContent(page);
		return tab;
	}

	private void loadColumn(){
		TableColumn fornavnColumn = new TableColumn<>();

		fornavnColumn.setText("Fornavn");

		table.getColumns().add(fornavnColumn);
	}

}
