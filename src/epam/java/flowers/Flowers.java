package epam.java.flowers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import epam.java.flowers.Flower.FlowerType;

public class Flowers {

	private List<Bouquet> bouquets;
	private List<Flower> flowers;

	public Flowers(List<Bouquet> bouquets, List<Flower> flowers) {
		this.bouquets = bouquets;
		this.flowers = flowers;
	}

	public static void main(String[] args) {
		 List<Bouquet> bouquets=new ArrayList<>();
		 List<Flower> flowers=new ArrayList<>();
		 flowers.add(new Bougainvillea(new Date(),new BigDecimal(10.5),10.56,FlowerType.Subtropical));
		 flowers.add(new Bougainvillea(new Date(),new BigDecimal(20.5),20.56,FlowerType.Subtropical));
		 flowers.add(new WhiteRose(new Date(),new BigDecimal(10.5),10.56,FlowerType.Temperate));
		 flowers.add(new Rose(new Date(),new BigDecimal(50.5),45.45,FlowerType.Temperate));
		 flowers.add(new Rose(new Date(),new BigDecimal(20.5),35.12,FlowerType.Temperate));
		 bouquets.add(new Bouquet(flowers));
		 bouquets.add(new Bouquet(flowers));
		 Flowers fff=new Flowers(bouquets,flowers);
		 System.out.println("Longest "+fff.getBouquets().get(1).getLongest());
		 System.out.println("Sum For Bouquet "+fff.getBouquets().get(1).getSum());
		 System.out.println("Freshest "+ fff.getFreshestBouquet());
	}

	public Bouquet getFreshestBouquet() {
		Bouquet bouquet = null;
		Date date = new Date();
		for (Bouquet bouque : bouquets) {
			if (bouque.getDate().before(date)) {
				bouquet = bouque;
			}
		}
		return bouquet;
	}

	public List<Bouquet> getBouquets() {
		return bouquets;
	}

	public void setBouquets(List<Bouquet> bouquets) {
		this.bouquets = bouquets;
	}

	public List<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}

	public static double doubleRandomInclusive(double max, double min) {
		double r = Math.random();
		if (r < 0.5) {
			return ((1 - Math.random()) * (max - min) + min);
		}
		return (Math.random() * (max - min) + min);
	}

	@Override
	public String toString() {
		return "Flowers [bouquets=" + bouquets + ", flowers=" + flowers + "]";
	}

}

//				Supplier<Flower> supplierFlowers = () -> new Bougainvillea(new Date(),new BigDecimal(doubleRandomInclusive(10.45,20.56)),doubleRandomInclusive(10.45,20.56),FlowerType.Subtropical);
//				List<Flower> flowers= Stream
//		            .generate(supplierFlowers)
//		            .limit(10)
//		            .collect(Collectors.toList());
//		 Supplier<Bouquet> supplierBouquet = () -> new Bouquet(flowers);
//		 List<Bouquet> bouquets = Stream
//	            .generate(supplierBouquet)
//	            .limit(10)
//	            .collect(Collectors.toList());
