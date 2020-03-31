import java.util.Date;
import java.util.Collection;

public class Vragenlijst {

	private int id;
	private String naam;
	private int aankoopprijs;
	private Date lifetime_best;

	public Vragenlijst(int id, String naam)
	{
		this.id = id;
		this.naam = naam;
	}

	public Thema getThema() {
		return null;
	}

	public Collection<Vraag> getVragen() {
		return null;
	}

	public int getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}
}
