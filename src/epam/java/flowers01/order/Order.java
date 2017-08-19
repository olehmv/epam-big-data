package epam.java.flowers01.order;

import java.util.LinkedList;
import java.util.List;

import epam.java.flowers01.delivery.IDelivery;
import epam.java.flowers01.item.Item;
import epam.java.flowers01.payment.IPayment;

public class Order {

	private List<Item> items;
	private IPayment payment;
	private IDelivery delivery;

	public Order(List<Item> items, IPayment payment, IDelivery delivery) {
		super();
		this.items = items;
		this.payment = payment;
		this.delivery = delivery;
		System.out.println("Creating order with "+items.size()+" items...");
	}

	public Order() {
		items = new LinkedList<>();
	}

	public void processOrder() {
		double p = payment.pay(calculateTotalPrice());
		double d = delivery.deliver(items);
		System.out.println("Payment fee: "+p + " Delivery cost: " + d);
		double t=p+ d+calculateTotalPrice();
		System.out.println("Total price for order: "+t);

	}

	public void addItem(Item item) {
		System.out.println("Adding Item... "+item+"...end .\n");
		items.add(item);
	}

	public void removeItem(Item item) {
		System.out.println("\n"+"Removing Item..."+item+"...end .\n");
		items.remove(item);
	}

	

	public double calculateTotalPrice() {
		double total = 0;
		for (Item item : items) {
			total = total + item.price();
		}
		System.out.println("Calculate total items price- "+total);
		return total;
	}

	@Override
	public String toString() {
		String formatedItems = items.toString().replace(",", "").replace("[", "").replace("]", "").replace("RibbonDecorator", " RibbonDecorator").replace("FlowerBucket", " FlowerBucket").trim();
		return "Order items:\n " + formatedItems + "\n Payment=" + payment + "\n Delivery=" + delivery + "";
	}

}
