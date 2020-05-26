import java.util.Collection;

public class Game {

	public boolean run;
	public Gebruiker gebruiker;
	private QuizMaker quizMaker;
	private Shop shop;

	public Game() {
		run = true;
		gebruiker = new Gebruiker();
		quizMaker = new QuizMaker(new StandardStrategy());
		shop = new Shop();
	}

	public Collection<Vragenlijst> askVragenlijstOverview() {
		return gebruiker.getOwnedVragenlijsten();
	}

	public Vraag selectVragenlijst(int selected) {
		Vragenlijst chosenVragenlijst = null;
		Collection<Vragenlijst> lijsten = gebruiker.getOwnedVragenlijsten();

		for (Vragenlijst vragenlijst : lijsten) {
			if (vragenlijst.getId() == selected) {
				chosenVragenlijst = vragenlijst;
			}
		}
		if (chosenVragenlijst == null) {
			System.out.println("Can't find vragenlijst on given parameter.");
			return null;
		}

		return quizMaker.play(chosenVragenlijst);
	}

	public Vraag giveAntwoord(String antwoord) {
		return quizMaker.answer(antwoord);
	}

	public ResultObject getResults() {
		ResultObject resultaten = quizMaker.getTotalResult();
		gebruiker.addMunten(resultaten.munten);
		gebruiker.addPunten(resultaten.punten);
		if (resultaten.amountRight > quizMaker.currentVragenlijst.getLifetime_best()) {
			for (Vragenlijst lijst : gebruiker.getOwnedVragenlijsten()) {
				if (lijst.getId() == quizMaker.currentVragenlijst.getId()) {
					lijst.setLifetime_best(resultaten.amountRight);
				}
			}
		}
		return resultaten;
	}

	public Collection<Vragenlijst> askShopVragenlijstOverview()
	{
		return shop.getVragenlijsten();
	}

	public Receipt buyVragenlijst(int selected) {
		return shop.buyVragenlijst(selected, gebruiker);
	}
}
