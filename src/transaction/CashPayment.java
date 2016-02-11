package transaction;

public class CashPayment implements Payment {
	private final float amount;

	public CashPayment(float amount) {
		this.amount = amount;
	}

	/**
	 *
	 */
	@Override
	public boolean authorize(float requiredAmount) {
		return requiredAmount <= amount;
	}

	/**
	 * 
	 */
	@Override
	public float cashBack(float requiredAmount) {
		return amount - requiredAmount;
	}
}
