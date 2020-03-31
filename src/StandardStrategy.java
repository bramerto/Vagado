public class StandardStrategy implements PuntentellingStrategy {

	public ResultObject execute(int amountGood) {
		ResultObject results = new ResultObject();

		results.amountRight = amountGood;
		results.amountWrong = 10 - amountGood;
		results.munten = (amountGood == 10) ? 2 : 0;
		results.punten = (amountGood == 10) ? amountGood + 2 : amountGood;

		return results;
	}
}
