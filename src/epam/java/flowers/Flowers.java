package epam.java.flowers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Flowers {

	private List<Bouquet> bouquets;
	private List<Flower> flowers;

	public Flowers(List<Bouquet> bouquets, List<Flower> flowers) {
		this.bouquets = bouquets;
		this.flowers = flowers;
	}

	public static void main(String[] args) {
		List<Bouquet> bouquets = new ArrayList<>();
		List<Flower> flowers = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			flowers.add(new Flower(new Date(System.nanoTime()), new BigDecimal(4), 5, FlowerType.Cactus.PILLY, new Container(new BigDecimal(23),3,ContainerType.CLAY,Color.BLUE)));
			flowers.add(new Flower(new Date(System.nanoTime()), new BigDecimal(5), 4,
					FlowerType.Bougainvillea.BARBARAKARST));
			flowers.add(
					new Flower(new Date(System.nanoTime()), new BigDecimal(6), 3, FlowerType.Rose.WHITEROSE));
			flowers.add(new Flower(new Date(System.nanoTime()), new BigDecimal(7), 2, FlowerType.Daffodils.MOUNTHOOD
				));
			flowers.add(new Flower(new Date(System.nanoTime()), new BigDecimal(8), 1, FlowerType.Peonies.FERNLEAFPEONY
				));
			flowers.add(new Flower(new Date(System.nanoTime()), new BigDecimal(8), 6, FlowerType.Peonies.FERNLEAFPEONY
					,new Container(new BigDecimal(50),5,ContainerType.PlASTIC,Color.RED)));
			bouquets.add(new Bouquet(flowers));
			bouquets.add(new Bouquet(flowers));
		}
		Flowers fff = new Flowers(bouquets, flowers);
		System.out.println("Freshest " + fff.getFreshestBouquet() + "\n");
		System.out.println("Longest - " + fff.getBouquets().get(1).getLongest());
		System.out.println("Sum For Bouquet - " + fff.getBouquets().get(1).getSum() + "\n");
		System.out.println("Buquet with "+FlowerType.Cactus.PILLY+" is: \n"+fff.findBouquetByFlower(FlowerType.Cactus.PILLY));

	}

	public Bouquet findBouquetByFlower(Type type) {
		for (Bouquet bouquet : bouquets) {
			for(Flower f: bouquet.getFlowers()) {
				if(f.getType().equals(type)) {
					return bouquet;
				}
			}
		}
		return null;
	}

	public Bouquet getFreshestBouquet() {
		Bouquet bouquet = null;
		Date date = new Date(System.nanoTime());
		for (Bouquet bouque : bouquets) {
			if (bouque.getDate().before(date)) {
				date = bouque.getDate();
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

// flowers.add(new Bougainvillea(new Date(System.nanoTime()),new
// BigDecimal(10.5),10.56,BougainvilleaType.BarbaraKarst));
// flowers.add(new Bougainvillea(new Date(System.nanoTime()),new
// BigDecimal(20.5),20.56,BougainvilleaType.VeraPurple));
// flowers.add(new Daffodils(new Date(System.nanoTime()),new
// BigDecimal(10.5),10.56,DaffodilsType.MountHood));
// flowers.add(new Rose(new Date(System.nanoTime()),new
// BigDecimal(50.5),45.45,RoseType.WhiteRose));
// flowers.add(new Peonies(new Date(System.nanoTime()),new
// BigDecimal(20.5),35.12,PeoniesType.FestivaMaxima));

// Supplier<Flower> supplierFlowers = () -> new Bougainvillea(new Date(),new
// BigDecimal(doubleRandomInclusive(10.45,20.56)),doubleRandomInclusive(10.45,20.56),FlowerType.Subtropical);
// List<Flower> flowers= Stream
// .generate(supplierFlowers)
// .limit(10)
// .collect(Collectors.toList());
// Supplier<Bouquet> supplierBouquet = () -> new Bouquet(flowers);
// List<Bouquet> bouquets = Stream
// .generate(supplierBouquet)
// .limit(10)
// .collect(Collectors.toList());
