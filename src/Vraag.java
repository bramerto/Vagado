public abstract class Vraag {

	private int id;

	private String vraag;

	private String antwoord;

	public Thema getThema() {
		return null;
	}

	public boolean check(String antwoord) {
		return false;
	}

	public String getVraag() {
		return vraag;
	}
}
