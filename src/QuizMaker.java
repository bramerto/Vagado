import java.util.Collection;

public class QuizMaker {

	PuntentellingStrategy puntentellingStrategy;
	Vragenlijst currentVragenlijst;
	Vraag currentVraag;

	public QuizMaker(PuntentellingStrategy strategy)
	{
		puntentellingStrategy = strategy;
	}

	public Vraag play(Vragenlijst selected) {
		currentVragenlijst = selected;
		Collection<Vraag> vragen = currentVragenlijst.getVragen();
		return null;
	}

	public Vraag answer(String antwoord) {
		return null;
	}

	public ResultObject getTotalResult() {
		return null;
	}
}
