package billCollector;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
				Parent root=FXMLLoader.load(getClass().getResource("BillCollector.fxml"));
				Scene scene = new Scene(root,600,300);
				primaryStage.setScene(scene);
				primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}