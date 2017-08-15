package epam.java.flowers01.decorator;

import epam.java.flowers01.item.Item;

public abstract class ItemDecorator extends Item {
	protected Item item;

	public ItemDecorator(Item item, String description, double price) {
		super(description, price);
		this.item = item;
	}

	@Override
	public abstract String getDescription();

}
