package epam.java.flowers01.decorator;

import epam.java.flowers01.item.Item;

public class PaperDecorator extends ItemDecorator {

	public PaperDecorator(Item item, String description, double price) {
		super(item, description, price);
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double price() {
		return price+item.price();
	}

	@Override
	public String toString() {
		return "PaperDecorator  description " + description + " price " + price + "\n"+ item ;
	}
	

}
