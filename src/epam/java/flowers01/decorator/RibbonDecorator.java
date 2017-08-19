package epam.java.flowers01.decorator;

import epam.java.flowers01.item.Item;

public class RibbonDecorator extends ItemDecorator {

	public RibbonDecorator(Item item, String description, double price) {
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

	@Override
	public String toString() {
		return "RibbonDecorator  description " + description + "  price " + price + "\n" + item ;
	}
	

}
