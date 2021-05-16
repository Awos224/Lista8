package application;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

import javafx.event.ActionEvent;

public class LogIn {

	public LogIn() {

	}

	@FXML
	private TextField nick;

	@FXML
	private TextField name;

	@FXML
	private TextField mail;

	@FXML
	private TextField surname;

	@FXML
	private RadioButton femaleTrue;

	@FXML
	private RadioButton maleTrue;

	@FXML
	private ToggleGroup gr1;

	@FXML
	private TextArea info;

	@FXML
	void goBack(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Menu.fxml");
	}

	@FXML
	void clickMe(ActionEvent event) {
		if (emptyValidation()) {
			try {
				validation();
			} catch (Exception e) {
				info.setText(e.getMessage());
			}
		} else
			info.setText("Podaj wszystkie dane");
	}

	public void validation() throws EmailException, NickException, NameException, SexException {

		if (emailValidation(mail.getText())) {
			if (nickValidation(nick.getText())) {
				if (nameValidation(name.getText()) && nameValidation(surname.getText())) {
					if (sexValidation(name.getText())) {
						Player p1 = new Player(nick.getText(), name.getText(), surname.getText(), mail.getText(),
								maleTrue.isSelected());
						info.setText(p1.getInfo());
					} else
						throw new SexException("Podaj imie zgodne z plcia!");
				} else
					throw new NameException("Podaj poprawne imie i nazwisko!");
			} else
				throw new NickException("Podaj poprawny nick!");
		} else
			throw new EmailException("Nieprawidlowa domena!");
	}

	public Boolean emptyValidation() {
		if (mail.getText() != "" && nick.getText() != "" && name.getText() != "" && surname.getText() != "")
			return true;
		else
			return false;

	}

	public Boolean emailValidation(String email) {
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@')
				if (email.indexOf("@gra.pl") != -1)
					return true;
		}
		return false;
	}

	public Boolean nickValidation(String nick) {
		if (nick.length() >= 6) {
			for (int i = 0; i < nick.length(); i++) {
				if (Character.isDigit(nick.charAt(i)))
					return true;
			}
			return false;
		} else
			return false;
	}

	public Boolean nameValidation(String name) {
		if (Character.isUpperCase(name.charAt(0)) && name.matches("[a-zA-Z]+"))
			return true;
		else
			return false;
	}

	public Boolean sexValidation(String name) {
		if ((name.substring(name.length() - 2, name.length()).equals("ek")) && femaleTrue.isSelected())
			return false;
		else if ((name.substring(name.length() - 3, name.length()).equals("usz")) && femaleTrue.isSelected())
			return false;
		else if ((name.substring(name.length() - 2, name.length()).equals("ta")) && maleTrue.isSelected())
			return false;
		else if ((name.substring(name.length() - 2, name.length()).equals("na")) && maleTrue.isSelected())
			return false;
		else
			return true;
	}

}
