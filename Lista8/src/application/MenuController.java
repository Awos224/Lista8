package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

public class MenuController {

	@FXML
	private Button zad1;

	@FXML
	private Button zad3;

	@FXML
	void click1(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Zad1.fxml");
	}

	@FXML
	void click2(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");

	}

}
