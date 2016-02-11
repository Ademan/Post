package transaction;

import storefile.Item;

public class LineItem {
	private final Item item;
	private int quantity;

	public LineItem(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public Item getItem() { return item; }

	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
}
