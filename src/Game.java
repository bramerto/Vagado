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
		System.out.println("- selectVragenlijst {vragenlijst_id}");
		System.out.println("- giveAntwoord {antwoord}");
		System.out.println("- getResults");
		System.out.println("- askShopVragenlijstOverview");
		System.out.println("- buyVragenlijst {vragenlijst_id}");

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
						System.out.println("id | naam");
						System.out.println("---------");
						collection.forEach(vragenlijst -> {
							System.out.println(vragenlijst.getId() + "  | " + vragenlijst.getNaam());
						});
						break;
					}
					System.out.println("Gebruiker has no vragenlijsten.");

					break;

				case "selectVragenlijst":
					if (!parameter.equals("")) {
						Vraag vraag = game.selectVragenlijst(Integer.parseInt(parameter));
						if (vraag != null) {
							System.out.println(vraag.getVraag());
							break;
						}
						System.out.println("Selected vragenlijst has no questions.");
						break;
					}

					System.out.println("selectVragenlijst needs a parameter.");
					break;

				case "giveAntwoord":
					if (!parameter.equals("")) {
						Vraag nextVraag = game.giveAntwoord(parameter);
						if (nextVraag == null) {
							System.out.println("No more questions in vragenlijst. Run 'getResults' to see results.");
							break;
						}
						System.out.println(nextVraag.getVraag());
						break;
					}
					System.out.println("giveAntwoord needs a parameter.");
					break;

				case "getResults":
					ResultObject results = game.getResults();
					results.PrintOut();
					break;

				case "askShopVragenlijstOverview":
					Collection<Vragenlijst> shopCollection = game.askShopVragenlijstOverview();

					System.out.println("S H O P");
					System.out.println("id | naam");
					System.out.println("---------");
					shopCollection.forEach(vragenlijst -> {
						System.out.println(vragenlijst.getId() + "  | " + vragenlijst.getNaam());
					});
					break;

				case "buyVragenlijst":
					game.buyVragenlijst(Integer.parseInt(parameter));
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
		Vragenlijst chosenVragenlijst = null;
		Collection<Vragenlijst> vragenlijsten = gebruiker.getOwnedVragenlijsten();

		for (Vragenlijst vragenlijst : vragenlijsten) {
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
		return quizMaker.getTotalResult();
	}

	public Collection<Vragenlijst> askShopVragenlijstOverview()
	{
		return null;
	}

	public Receipt buyVragenlijst(int selected) {
		return shop.buyVragenlijst(selected, gebruiker.getId());
	}
}
