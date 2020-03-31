public class Receipt {

	private int price;
	private Vragenlijst lijst;
	private boolean isAdded;

	public void Printout()
	{
		System.out.println("Receipt");
		System.out.println("Price " + price);
		System.out.println("------------");
		System.out.println("Vragenlijst");
		System.out.println("id: " + lijst.getId());
		System.out.println("id: " + lijst.getNaam());
		System.out.println("------------");
		System.out.println("Is added to account: " + isAdded);
	}
}
