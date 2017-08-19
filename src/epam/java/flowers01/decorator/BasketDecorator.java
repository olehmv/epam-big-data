package epam.java.flowers01.decorator;

import epam.java.flowers01.item.Item;

public class BasketDecorator extends ItemDecorator {

	public BasketDecorator(Item item, String description, double price) {
		super(item, description, price);
	}

	@Override
	public double price() {
		return price+item.price();
	}

	@Override
	public String getDescription() {
		return description;
	}

}
