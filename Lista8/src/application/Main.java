package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	private static Stage stg1;

	@Override
	public void start(Stage stage) {
		try {
			stg1 = stage;
			GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene scene = new Scene(root, 400, 550);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Lista 8");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg1.getScene().setRoot(pane);
	}

}
