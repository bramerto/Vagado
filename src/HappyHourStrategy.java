public class HappyHourStrategy implements PuntentellingStrategy {

	public ResultObject execute(int amountGood) {
		ResultObject results = new ResultObject();

		results.amountRight = amountGood;
		results.amountWrong = 10 - amountGood;
		results.munten = ((amountGood * 1.25) > 10) ? 4 : 0;
		results.punten = ((amountGood * 1.25) > 10) ? amountGood + 4 : amountGood;

		return results;
	}
}
