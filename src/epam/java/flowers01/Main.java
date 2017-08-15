package epam.java.flowers01;

import java.util.ArrayList;
import java.util.List;

import epam.java.flowers01.decorator.PaperDecorator;
import epam.java.flowers01.decorator.RibbonDecorator;
import epam.java.flowers01.delivery.PostDeliveryStrategy;
import epam.java.flowers01.flower.CactusFlower;
import epam.java.flowers01.flower.Flower;
import epam.java.flowers01.flower.FlowerBucket;
import epam.java.flowers01.flower.FlowerColor;
import epam.java.flowers01.flower.FlowerSpec;
import epam.java.flowers01.flower.FlowerType;
import epam.java.flowers01.flower.RomashkaFlower;
import epam.java.flowers01.item.Item;
import epam.java.flowers01.order.Order;
import epam.java.flowers01.payment.PayPalPaymentStrategy;

public class Main {

	public static void main(String[] args) {
		Item item = new FlowerBucket("White bucket", 45);
		FlowerBucket bucket = (FlowerBucket) item;
		List<Flower>flowers=new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			bucket.addFlower(new RomashkaFlower(true, 100, new FlowerSpec(FlowerColor.WHITE, 30, FlowerType.ROMASHKA)));
			bucket.addFlower(new RomashkaFlower(true, 100, new FlowerSpec(FlowerColor.WHITE, 30, FlowerType.ROMASHKA)));
		}
		flowers.addAll(bucket.getFlowers());
		bucket.addFlower(new CactusFlower(true, 300, new FlowerSpec(FlowerColor.RED, 7, FlowerType.CACTUS)));
		
		FlowerBucket.addFlowers((FlowerBucket) item,flowers);
		Flower flower=new CactusFlower(true, 300, new FlowerSpec(FlowerColor.RED, 7, FlowerType.CACTUS));
		System.out.print("Looking for "+flower.getSpec().getType()+"...\nFind: "+bucket
				.searchFlower(flower)+"In Bouquet composed of:\n");

		item = new RibbonDecorator(item, "Red ribbon", 5);
		item = new PaperDecorator(item, "Green paper decorator", 7);
		System.out.print(item.toString());
		System.out.println("Price for Bouquet: " + item.price()+"\n");
		List<Item>items=new ArrayList<>();
		items.add(flower);
		Order order=new Order(items, new PayPalPaymentStrategy(), new PostDeliveryStrategy());
		order.addItem(item);
		order.processOrder();
		System.out.println(order);
		order.removeItem(flower);
		order.processOrder();
		System.out.println(order);
	}

}
