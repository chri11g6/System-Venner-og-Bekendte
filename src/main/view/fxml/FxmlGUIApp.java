package main.view.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.view.iView;

public class FxmlGUIApp extends Application implements iView {
	@Override
	public void run() {
		launch("");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("window/UI.fxml"));
        primaryStage.setTitle("UI");
        primaryStage.setScene(new Scene(root, 976, 636));

		primaryStage.setResizable(false);

        primaryStage.show();
	}
	
}
