import java.util.Arrays;
import java.util.Collection;

public class Gebruiker {

	private int id;
	private String gebruikersnaam;
	private String wachtwoord;
	private int munten;
	private int punten;
	private boolean isMedewerker;

	private Collection<Vragenlijst> vragenlijsten;

	public Gebruiker()
	{
		id = 1337;
		gebruikersnaam = "Bram";
		munten = 2;
		punten = 0;
		Vragenlijst vragenlijst1 = new Vragenlijst(1, "fun");
		Vragenlijst vragenlijst2 = new Vragenlijst(2, "test");
		Vragenlijst vragenlijst3 = new Vragenlijst(3, "exam");
		vragenlijsten = Arrays.asList(vragenlijst1, vragenlijst2, vragenlijst3);
	}

	public Collection<Vragenlijst> getOwnedVragenlijsten() {
		return vragenlijsten;
	}

	public int getId() {
		return id;
	}

	public int getMunten() {
		return munten;
	}

	public int getPunten() {
		return punten;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void addPunten(int punten) {
		this.punten += punten;
	}

	public void addMunten(int munten) {
		this.munten += munten;
	}

	public void reduceMunten(int munten) {
		this.munten -= munten;
	}

	public void setVragenlijsten(Collection<Vragenlijst> vragenlijsten) {
		this.vragenlijsten = vragenlijsten;
	}
}
