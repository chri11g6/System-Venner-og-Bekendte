package view.gui.intersserTemp;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

import java.io.IOException;


public class IntersserTempController extends AnchorPane {
	public Label LabelText;

	public IntersserTempController() {		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("IntersserTemp.fxml"));

		loader.setRoot(this);
		loader.setController(this);
		
		try {
			loader.load();
		}catch (IOException e){
			throw new RuntimeException(e);
		}
	}

	public void buttonClickDelete(){
		
	}
}
