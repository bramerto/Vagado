public class ResultObject {

	public int munten;
	public int punten;
	public int amountRight;
	public int amountWrong;

	public void PrintOut()
	{
		System.out.println("Results quiz:");
		System.out.println("Munten earned: " + munten);
		System.out.println("Punten earned: " + punten);
		System.out.println("Amount right: " + amountRight);
		System.out.println("Amount wrong: " + amountWrong);
	}
}
