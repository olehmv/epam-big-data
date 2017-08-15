package epam.java.flowers01.delivery;

import java.util.List;

import epam.java.flowers01.item.Item;

public class PostDeliveryStrategy implements IDelivery {
	
	@Override
	public double deliver(List<Item> item) {
		double cost=0;
		for (Item itm : item) {
			cost=cost+itm.price();
		}
		cost=cost/100*10;
		System.out.println("Delivering "+item.size()+" items cost "+cost+" PostDelivery processing...");
		return cost;

	}

	@Override
	public String toString() {
		return "PostDeliveryStrategy";
	}
	
	
}
