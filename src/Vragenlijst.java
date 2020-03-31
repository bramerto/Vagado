import java.util.Arrays;
import java.util.Collection;

public class Vragenlijst {

	private int id;
	private String naam;
	private int aankoopprijs;
	private int lifetime_best;

	public Vragenlijst(int id, String naam)
	{
		this.id = id;
		this.naam = naam;
		this.lifetime_best = 0;
	}

	public Thema getThema() {
		return null;
	}

	public Collection<Vraag> getVragen() {

		String alternatief1 = "alternatief 1";
		String alternatief2 = "alternatief 2";
		String alternatief3 = "alternatief 3";

		MeerkeuzeVraag 	vraag1 = new MeerkeuzeVraag	(1, "Waarom is Java niet zo goed als Csharp?", "antwoord1", Arrays.asList(alternatief1, alternatief2, alternatief3));
		OpenVraag 		vraag2 = new OpenVraag		(2, "Waarom is Java niet zo goed als Csharp?", "antwoord2");
		MeerkeuzeVraag 	vraag3 = new MeerkeuzeVraag	(3, "Waarom is Java niet zo goed als Csharp?", "antwoord3", Arrays.asList(alternatief1, alternatief2, alternatief3));
		OpenVraag 		vraag4 = new OpenVraag		(4, "Waarom is Java niet zo goed als Csharp?", "antwoord4");
		MeerkeuzeVraag 	vraag5 = new MeerkeuzeVraag	(5, "Waarom is Java niet zo goed als Csharp?", "antwoord5", Arrays.asList(alternatief1, alternatief2, alternatief3));
		OpenVraag 		vraag6 = new OpenVraag		(6, "Waarom is Java niet zo goed als Csharp?", "antwoord6");
		MeerkeuzeVraag 	vraag7 = new MeerkeuzeVraag	(7, "Waarom is Java niet zo goed als Csharp?", "antwoord7", Arrays.asList(alternatief1, alternatief2, alternatief3));
		OpenVraag 		vraag8 = new OpenVraag		(8, "Waarom is Java niet zo goed als Csharp?", "antwoord8");
		MeerkeuzeVraag 	vraag9 = new MeerkeuzeVraag	(9, "Waarom is Java niet zo goed als Csharp?", "antwoord9", Arrays.asList(alternatief1, alternatief2, alternatief3));
		OpenVraag 		vraag10= new OpenVraag		(10,"Waarom is Java niet zo goed als Csharp?", "antwoord10");

		return Arrays.asList(vraag1, vraag2, vraag3, vraag4, vraag5, vraag6, vraag7, vraag8, vraag9, vraag10);
	}

	public void setLifetime_best(int lifetime_best) {
		this.lifetime_best = lifetime_best;
	}

	public int getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public int getLifetime_best() {
		return lifetime_best;
	}
}
