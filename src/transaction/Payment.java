package transaction;

public interface Payment {
	/**
	 * Determine whether the payment is sufficient
	 */
	public boolean authorize(float requiredAmount);

	/**
	 * Determine the amount of change to return
	 */
	public float cashBack(float requiredAmount);
}
