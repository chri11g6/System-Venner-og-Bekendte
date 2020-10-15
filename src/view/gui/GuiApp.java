package view.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiApp extends Application {
	public void run(String[] args){
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
		stage.setTitle("Venner og bekendte");
		stage.setScene(new Scene(root, 800, 800));

		stage.show();
	}
}
