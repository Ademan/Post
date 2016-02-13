package transaction;

import java.util.List;
import java.util.ArrayList;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.EOFException;
import java.io.Closeable;

import post.Customer;
import storefile.Catalog;
import storefile.Item;

import payment.Payment;
import payment.CreditPayment;
import payment.CashPayment;
import payment.CheckPayment;

public class TransactionReader implements Closeable {
	private BufferedReader reader;
	private Catalog catalog;

	public TransactionReader(Reader reader, Catalog catalog) {
		this.catalog = catalog;
		this.reader = new BufferedReader(reader);
	}

	public TransactionReader(BufferedReader reader, Catalog catalog) {
		this.catalog = catalog;
		this.reader = reader;
	}

	class TransactionBuilder {
		Customer customer;
		List<LineItem> items = new ArrayList<LineItem>();
		Payment payment;

		public TransactionBuilder() {}

		public void addLineItem(LineItem lineItem) {
			items.add(lineItem);
		}

		public void setPayment(Payment payment) {
			this.payment = payment;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public boolean valid() {
			return !(payment == null || customer == null);
		}
		public Transaction getTransaction() {
			if (valid()) {
				Transaction transaction = new Transaction(customer, items, payment);
				payment.setAmountDue(transaction.getAmountDue());
				return transaction;
			} else {
				return null;
			}
		}
	}

	/**
	 * Attempt to read next Transaction from file and return null on error
	 */
	public Transaction getNext() {
		TransactionBuilder builder = new TransactionBuilder();
		try {
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					Transaction transaction = builder.getTransaction();
					builder = new TransactionBuilder();
					return transaction;
				} else {
					line = line.trim();
				}

				if ("".equals(line)) {
					Transaction transaction = builder.getTransaction();
					builder = new TransactionBuilder();

					// If the transaction was valid, return it
					if (transaction != null) {
						return transaction;
					} else {
						// Otherwise we forget the current incomplete transaction, and continue parsing the file
						continue;
					}
				}

				Payment payment = tryParsePayment(line);
				if (payment != null) {
					builder.setPayment(payment);
					continue;
				}

				LineItem lineItem = tryParseLineItem(line);
				if (lineItem != null) {
                                        System.out.println(TextReceipt.createLineItemString(lineItem));
					builder.addLineItem(lineItem);
					continue;
				}

				Customer customer = new Customer(line);
                                System.out.println(customer.getName());
				builder.setCustomer(customer);
			}
	 	} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Extracts the dollar amount from a payment line
	 * @return The dollar amount as a float, we all know better than using floats for money!
	 */
	float getPaymentAmount(String line) throws IllegalArgumentException {
		int start = line.indexOf('$');
		if (0 < start && (start + 1) < line.length()) {
			String restOfLine = line.substring(start+1);
			
			return Float.parseFloat(restOfLine);	
		} else {
			throw new IllegalArgumentException("Failed to parse payment amount in line \"" + line + "\"");
		}
	}

	Payment tryParsePayment(String line) {
		// Note: Probably simpler with a regex
		try {
			if (line.startsWith("CHECK")) {
				float amount = getPaymentAmount(line);

				return new CheckPayment(0.0f);
			} else if (line.startsWith("CASH")) {
				float amount = getPaymentAmount(line);

				return new CashPayment(0.0f);
			} else if (line.startsWith("CREDIT")) {
				String[] components = line.split(" ");

				if (components.length != 2) {
					return null;
				}

				return new CreditPayment(0.0f, components[1]);
			} else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	boolean numeric(String s, int i) throws IndexOutOfBoundsException {
		char c = s.charAt(i);

		return '0' <= c && c <= '9';
	}

	LineItem tryParseLineItem(String line) {
		try {
			String upc = line.substring(0, 4);
			if (!(numeric(upc, 0) && numeric(upc, 1) && numeric(upc, 2) && numeric(upc, 3))) {
				return null;
			}

			String quantityString = line.substring(9);
			quantityString = quantityString.trim();

			int quantity = Integer.parseInt(quantityString, 10);
                        
			if (quantity < 1) {
				return null;
			}

			Item item = catalog.getItem(upc);
			if (item == null) {
				return null;
			}

			return new LineItem(item, quantity);
		} catch (IndexOutOfBoundsException e) {
			return null;
		} catch (NumberFormatException e) {
			return null;
		}
	}

	@Override
	public void close() throws IOException {
		reader.close();
	}
}
