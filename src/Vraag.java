public abstract class Vraag {

	protected int id;
	protected String vraag;
	protected String antwoord;

	public Vraag(int id, String vraag, String antwoord)
	{
		this.id = id;
		this.vraag = vraag;
		this.antwoord = antwoord;
	}

	public Thema getThema() {
		return null;
	}

	public boolean check(String antwoord) {
		return (antwoord.equals(this.antwoord));
	}

	public String getVraag() {
		return vraag;
	}
}
