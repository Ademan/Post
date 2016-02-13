package transaction;

public class CreditPayment implements Payment {
	private final String cardNumber;
	public CreditPayment(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 *
	 */
	@Override
	public boolean authorize(float requiredAmount) {
		return true; // TODO: implement RNG
	}

	/**
	 * 
	 */
	@Override
	public float cashBack(float requiredAmount) {
		return 0.0f;
	}
}
