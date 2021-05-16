package application;

public class Player {

	String nick, name, surname, email;
	Boolean male;

	public Player(String nick, String name, String surname, String email, Boolean male) {
		super();
		this.nick = nick;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.male = male;

	}

	public String getInfo() {
		if (male)
			return ("Nick: " + nick + "\nImie: " + name + "\nNazwisko: " + surname + "\nE-mail: " + email
					+ "\nPlec: Mezczyzna");
		else
			return ("Nick: " + nick + "\nImie: " + name + "\nNazwisko: " + surname + "\nE-mail: " + email
					+ "\nPlec: Kobieta");
	}
}
