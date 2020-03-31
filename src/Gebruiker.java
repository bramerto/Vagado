import java.util.Arrays;
import java.util.Collection;

public class Gebruiker {

	private int id;

	private String gebruikersnaam;

	private String wachtwoord;

	private int munten;

	private int punten;

	private boolean isMedewerker;

	public Collection<Vragenlijst> getOwnedVragenlijsten() {
		Vragenlijst vragenlijst1 = new Vragenlijst(1, "fun");
		Vragenlijst vragenlijst2 = new Vragenlijst(2, "test");
		Vragenlijst vragenlijst3 = new Vragenlijst(3, "exam");

		return Arrays.asList(vragenlijst1, vragenlijst2, vragenlijst3);
	}

	public int getId() {
		return id;
	}
}
