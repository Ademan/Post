package post;

/**
 * An object representing a customer
 */
public class Customer {
	/**
	 * The customer's full name
	 */
	private final String name;

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name;
	}
}
