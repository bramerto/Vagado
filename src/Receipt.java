public class Receipt {

	public int price;
	public Vragenlijst lijst;

	public void PrintOut()
	{
		System.out.println("Receipt");
		System.out.println("Price " + price);
		System.out.println("------------");
		System.out.println("Vragenlijst");
		System.out.println("id: " + lijst.getId());
		System.out.println("naam: " + lijst.getNaam());
		System.out.println("price: " + lijst.getAankoopprijs());
	}
}
