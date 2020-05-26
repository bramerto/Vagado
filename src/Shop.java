import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Shop {

	Collection<Vragenlijst> VragenlijstenInShop;

	public Shop()
	{
		Vragenlijst vragenlijst1 = new Vragenlijst(201, "buy_this_one");
		Vragenlijst vragenlijst2 = new Vragenlijst(305, "or_this_one2");
		Vragenlijst vragenlijst3 = new Vragenlijst(402, "not_this_one");

		VragenlijstenInShop = Arrays.asList(vragenlijst1, vragenlijst2, vragenlijst3);
	}

	public Receipt buyVragenlijst(int lijst_id, Gebruiker gebruiker) {
		Receipt receipt = null;
		for (Vragenlijst vragenlijst : VragenlijstenInShop) {
			int price = vragenlijst.getAankoopprijs();
			if (vragenlijst.getId() == lijst_id && gebruiker.getMunten() >= price) {
				receipt = new Receipt();
				gebruiker.reduceMunten(price);
				receipt.lijst = vragenlijst;
				receipt.price = price;

				ArrayList<Vragenlijst> vragenlijsten = new ArrayList<>(gebruiker.getOwnedVragenlijsten());
				vragenlijsten.add(vragenlijst);
				gebruiker.setVragenlijsten(vragenlijsten);
				receipt.gebruiker = gebruiker;
			}
		}

		return receipt;
	}

	public Collection<Vragenlijst> getVragenlijsten() {
		return VragenlijstenInShop;
	}

	public void addVragenlijst(Vragenlijst lijst) {

	}

	public void editVragenlijst(int lijst_id) {

	}

	public void deleteVragenLijst(int lijst_id) {

	}

	public Collection<Vraag> getVragen() {
		return null;
	}

	public void addVraag(Vraag vraag) {

	}

	public void editVraag(int vraag_id) {

	}

	public void deleteVraag(int vraag_id) {

	}

	public Collection<Thema> getThemas() {
		return null;
	}

	public void addThema(Thema thema) {

	}

	public void editThema(int thema_id) {

	}

	public void deleteThema(int thema_id) {

	}
}
