import java.util.Collection;
import java.util.Iterator;

public class QuizMaker {

	PuntentellingStrategy puntentellingStrategy;

	Vragenlijst currentVragenlijst;
	Iterator<Vraag> iterator;
	Vraag currentVraag;
	int amountGood;

	public QuizMaker(PuntentellingStrategy strategy)
	{
		puntentellingStrategy = strategy;
	}

	public Vraag play(Vragenlijst selected) {
		amountGood = 0;
		currentVragenlijst = selected;
		Collection<Vraag> vragen = currentVragenlijst.getVragen();
		iterator = vragen.iterator();
		currentVraag = iterator.next();

		return currentVraag;
	}

	public Vraag answer(String antwoord) {

		if (currentVraag.check(antwoord)) {
			amountGood++;
		}

		if (iterator.hasNext()) {
			currentVraag = iterator.next();
			return currentVraag;
		}
		return null;
	}

	public ResultObject getTotalResult() {
		ResultObject results = puntentellingStrategy.execute(amountGood);
		amountGood = 0;
		return results;
	}
}
