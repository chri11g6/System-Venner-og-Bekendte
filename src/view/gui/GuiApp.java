package view.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.iView;

public class GuiApp extends Application implements iView {
	public void run() {
		launch();
	}

	public void start(Stage stage) throws Exception {
		stage.setTitle("Venner og bekendte");
		stage.setScene(new Scene(new WindowsPage().load(), 640, 400));

		stage.show();
	}
}
