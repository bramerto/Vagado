import java.util.Collection;
import java.util.Scanner;

public class GameUI {

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
        System.out.println("- user");

        while (game.run) {
            String input = in.nextLine();
            String[] inputArray = input.split("\\s+");
            String parameter = "";

            if (inputArray.length > 1) {
                parameter = inputArray[1];
            }

            Collection<Vragenlijst> vragenlijsten;

            switch (inputArray[0]) {
                case "askVragenlijstOverview":
                    vragenlijsten = game.askVragenlijstOverview();
                    if (vragenlijsten != null) {
                        System.out.println("id | naam | lifetime best");
                        System.out.println("---------");
                        vragenlijsten.forEach(vragenlijst -> {
                            System.out.println(vragenlijst.getId() + "  | " + vragenlijst.getNaam() + " | " + vragenlijst.getLifetime_best());
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
                    vragenlijsten = game.askShopVragenlijstOverview();

                    System.out.println("S H O P");
                    System.out.println("id | naam | aankoopprijs");
                    System.out.println("---------");
                    vragenlijsten.forEach(vragenlijst -> {
                        System.out.println(vragenlijst.getId() + "  | " + vragenlijst.getNaam() + " | " + vragenlijst.getAankoopprijs());
                    });
                    break;

                case "buyVragenlijst":
                    Receipt bonnetje = game.buyVragenlijst(Integer.parseInt(parameter));
                    if (bonnetje == null) {
                        System.out.println("Can't find vragenlijst on given parameter or gebruiker does not have enough munten.");
                        break;
                    }
                    bonnetje.Printout();
                    break;
                case "user":
                    System.out.println("gebruiker - " + game.gebruiker.getGebruikersnaam() + " (" + game.gebruiker.getId() + ")");
                    System.out.println("huidige munten: " + game.gebruiker.getMunten());
                    System.out.println("huidige punten: " + game.gebruiker.getPunten());
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
}
