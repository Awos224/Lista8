package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Zad1Controller {

	@FXML
	private TextArea txt1;

	@FXML
	private TextArea txt2;

	@FXML
	private TextArea txt3;

	@FXML
	private Button test1;

	@FXML
	private Button test2;

	@FXML
	private Button test3;

	@FXML
	void click1(ActionEvent event) {
		int[] arr = new int[2];
		try {
			arr[8] = 5;
		} catch (ArrayIndexOutOfBoundsException e) {
			txt1.setText("int[] arr = new int[2];" + "\narr[8] = 5;\n" + e.getMessage());
		}
	}

	@FXML
	void click2(ActionEvent event) {
		try {
			int n = Integer.parseInt("Test");
			txt2.setText(Integer.toString(n));
		} catch (NumberFormatException e) {
			txt2.setText("int n = Integer.parseInt (\"Test\") ;\n" + e.getMessage());
		}
	}

	@FXML
	void click3(ActionEvent event) {
		try {
			int a = 1, b = 0;
			int c = a / b;
			txt2.setText(Integer.toString(c));
		} catch (ArithmeticException e) {
			txt3.setText("int a = 1, b = 0;" + "\nint c = a/b;\n" + e.getMessage());
		}
	}

	@FXML
	void goBack(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Menu.fxml");
	}

}
