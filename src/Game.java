import java.util.Collection;
import java.util.Scanner;

public class Game {

	private boolean run;
	private Gebruiker gebruiker;
	private QuizMaker quizMaker;
	private Shop shop;

	public Game() {
		run = true;
		gebruiker = new Gebruiker();
		quizMaker = new QuizMaker(new StandardStrategy());
		shop = new Shop();
	}

	public static void main(String[] args) {

		Game game = new Game();
		Scanner in = new Scanner(System.in);

		System.out.println("Run command in list or type exit to exit program.");
		System.out.println("- askVragenlijstOverview");
		System.out.println("- selectVragenlijst");
		System.out.println("- giveAntwoord");
		System.out.println("- getResults");

		while (game.run) {
			String input = in.nextLine();
			String[] inputArray = input.split("\\s+");
			String parameter = "";

			if (inputArray.length > 1) {
				parameter = inputArray[1];
			}

			switch (inputArray[0]) {
				case "askVragenlijstOverview":
					Collection<Vragenlijst> collection = game.askVragenlijstOverview();
					if (collection != null) {
						collection.forEach(vragenlijst -> {
							System.out.println(vragenlijst.getId() + " " + vragenlijst.getNaam());
						});
					} else {
						System.out.println("Gebruiker has no vragenlijsten.");
					}
					break;

				case "selectVragenlijst":
					if (!parameter.equals("")) {
						Vraag vraag = game.selectVragenlijst(Integer.parseInt(parameter));
						System.out.println(vraag.getVraag());
						break;
					}

					System.out.println("selectVragenlijst needs a parameter.");
					break;

				case "giveAntwoord":
					if (!parameter.equals("")) {
						Vraag nextVraag = game.giveAntwoord(parameter);
						System.out.println(nextVraag.getVraag());
						break;
					}
					System.out.println("giveAntwoord needs a parameter.");

					break;

				case "getResults":
					ResultObject results = game.getResults();
					results.PrintOut();
					break;

				case "exit":
				case"quit":
					game.run = false;
					break;

				default:
					System.out.println("Command not recognized.");
					break;
			}
		}
	}

	public Collection<Vragenlijst> askVragenlijstOverview() {
		return gebruiker.getOwnedVragenlijsten();
	}

	public Vraag selectVragenlijst(int selected) {
		final Vragenlijst[] chosenVragenlijst = {null};
		Collection<Vragenlijst> vragenlijsten = gebruiker.getOwnedVragenlijsten();
		vragenlijsten.forEach(vragenlijst -> {
			if (vragenlijst.getId() == selected) {
				chosenVragenlijst[0] = vragenlijst;
			}
		});

		return quizMaker.play(chosenVragenlijst[0]);
	}

	public Vraag giveAntwoord(String antwoord) {
		return quizMaker.answer(antwoord);
	}

	public ResultObject getResults() {
		return quizMaker.getTotalResult();
	}

	public Receipt buyVragenlijst(int selected) {
		return shop.buyVragenlijst(selected, gebruiker.getId());
	}
}
