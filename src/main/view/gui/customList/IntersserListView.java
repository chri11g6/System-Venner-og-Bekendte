package main.view.gui.customList;

import main.dto.Interesser;
import main.dto.iInteresser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class IntersserListView {

	public ObservableList<iInteresser> items;

	public ListView load() {
		ListView<iInteresser> list = new ListView<iInteresser>();
		items = FXCollections.observableArrayList();

		items.addAll(new Interesser("Skak"), new Interesser("CounterStrike"), new Interesser("Litteratur"), new Interesser("Natur"));

		list.setItems(items);

		list.setCellFactory(
			(Callback<ListView<iInteresser>, ListCell<iInteresser>>) new Callback<ListView<iInteresser>, ListCell<iInteresser>>(){
				@Override
				public ListCell<iInteresser> call(ListView<iInteresser> list) {
					return new CustomListCell();
				}
			});

		return list;
	}

	private class CustomListCell extends ListCell<iInteresser> {
		private HBox rightBox;
		private HBox leftBox;
		private AnchorPane anchorPane;
		private Text name;
		private Button button;
	
		public CustomListCell() {
			super();
	
			anchorPane = new AnchorPane();
	
			name = new Text();
			CreateButton();
	
			leftBox = new HBox(name);
	
			rightBox = new HBox(button);
	
			AnchorPane.setLeftAnchor(leftBox, 0d);
			AnchorPane.setRightAnchor(rightBox, 0d);
	
			ObservableList list = anchorPane.getChildren();
			list.addAll(rightBox, leftBox);
		}
	
		private void buttonAction() {
			System.out.println(name.getText());
		}

		@Override
		protected void updateItem(iInteresser item, boolean empty) {
			super.updateItem(item, empty);
			if (item != null && !empty) { // <== test for null item and empty parameter
				name.setText(item.getNavn());
				setGraphic(anchorPane);
			} else {
				setGraphic(null);
			}
		}
	
		private void CreateButton(){
			button = new Button();
			SVGPath svgIcon = new SVGPath();
			svgIcon.setContent("M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM19 4h-3.5l-1-1h-5l-1 1H5v2h14V4z");
	
			button.setGraphic(svgIcon);
			button.setStyle("-fx-background-color: transparent;");

			button.setOnAction(e -> buttonAction());
		}
	}
}
