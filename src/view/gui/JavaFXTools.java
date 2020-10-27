package view.gui;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class JavaFXTools {
	public static void setAnchor(Node item){
		AnchorPane.setBottomAnchor(item, 0d);
		AnchorPane.setLeftAnchor(item, 0d);
		AnchorPane.setRightAnchor(item, 0d);
		AnchorPane.setTopAnchor(item, 0d);
	}

	public static void setAnchor(Node item, Double tal){
		AnchorPane.setBottomAnchor(item, tal);
		AnchorPane.setLeftAnchor(item, tal);
		AnchorPane.setRightAnchor(item, tal);
		AnchorPane.setTopAnchor(item, tal);
	}

	public static void setAnchor(Node item, Double top, Double right, Double bottom, Double left){
		AnchorPane.setBottomAnchor(item, bottom);
		AnchorPane.setLeftAnchor(item, left);
		AnchorPane.setRightAnchor(item, right);
		AnchorPane.setTopAnchor(item, top);
	}
}
