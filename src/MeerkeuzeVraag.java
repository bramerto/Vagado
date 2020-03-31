import java.util.*;

public class MeerkeuzeVraag extends Vraag {

	private List<String> alternatieve_antwoorden;

	public MeerkeuzeVraag(int id, String vraag, String antwoord, List<String> alternatieve_antwoorden) {
		super(id, vraag, antwoord);
		this.alternatieve_antwoorden = alternatieve_antwoorden;
	}

	@Override
	public String getVraag() {
		String vraag = super.getVraag() + " Antwoorden: ";

		ArrayList<String> antwoorden = new ArrayList<>(alternatieve_antwoorden);
		antwoorden.add(antwoord);

		Collections.shuffle(antwoorden, new Random());

		for (String antwoord : antwoorden) {
			vraag = vraag.concat(antwoord + " ");
		}

		return vraag;
	}
}
