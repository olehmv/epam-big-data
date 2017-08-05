package epam.java.flowers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import epam.java.flowers.FlowerType.BougainvilleaType;
import epam.java.flowers.FlowerType.DaffodilsType;
import epam.java.flowers.FlowerType.PeoniesType;
import epam.java.flowers.FlowerType.RoseType;

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
		 for (int i = 0; i < 10; i++) {
		 flowers.add(new Bougainvillea(new Date(System.nanoTime()),new BigDecimal(10.5),10.56,BougainvilleaType.BarbaraKarst));
		 flowers.add(new Bougainvillea(new Date(System.nanoTime()),new BigDecimal(20.5),20.56,BougainvilleaType.VeraPurple));
		 flowers.add(new Daffodils(new Date(System.nanoTime()),new BigDecimal(10.5),10.56,DaffodilsType.MountHood));
		 flowers.add(new Rose(new Date(System.nanoTime()),new BigDecimal(50.5),45.45,RoseType.WhiteRose));
		 flowers.add(new Peonies(new Date(System.nanoTime()),new BigDecimal(20.5),35.12,PeoniesType.FestivaMaxima));
		 bouquets.add(new Bouquet(flowers));
		 bouquets.add(new Bouquet(flowers));
		 }
		 Flowers fff=new Flowers(bouquets,flowers);
		 System.out.println("Freshest "+ fff.getFreshestBouquet()+"\n");
		 System.out.println("Longest - "+fff.getBouquets().get(1).getLongest());
		 System.out.println("Sum For Bouquet - "+fff.getBouquets().get(1).getSum());
	}

	public Bouquet getFreshestBouquet() {
		Bouquet bouquet = null;
		Date date = new Date(System.nanoTime());
		for (Bouquet bouque : bouquets) {
			if (bouque.getDate().before(date)) {
				date=bouque.getDate();
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
