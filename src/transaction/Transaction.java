package transaction;

import java.util.List;
import java.util.ArrayList;

import post.Customer;

import payment.Payment;

import storefile.Item;

public class Transaction {
	private Customer customer;
	private List<LineItem> items;
	private Payment payment;

	public Transaction(Customer customer, List<LineItem> items, Payment payment) {
		this.customer = customer;
		this.items = items;
		this.payment = payment;	
	}

	public List<LineItem> getItems() { return items; }
	public Payment getPayment() { return payment; }
	public Customer getCustomer() { return customer; }

	public float getAmountDue() {
		double amountDue = 0.0;

		for (LineItem lineItem : items) {
			Item item = lineItem.getItem();

			amountDue += item.getPrice() * lineItem.getQuantity();
		}

		return (float)amountDue;
	}
}
