package epam.java.flowers01.flower;

import java.util.LinkedList;
import java.util.List;

import epam.java.flowers01.item.Item;

public class FlowerBucket extends Item {
	private List<Flower> flowers;

	public FlowerBucket(String description, double price) {
		super(description, price);
		setFlowers(new LinkedList<>());
	}
	private double calculatePriceForFlowers(){
		double price=0;
		for (Flower flower : getFlowers()) {
			price=price+flower.price();
		}
		return price;
	}

	@Override
	public double price() {
		if(getFlowers().isEmpty())return price;
		return price+calculatePriceForFlowers();
	}

	public Flower searchFlower(Flower flower) {
		for (Flower flow : getFlowers()) {
			if (flow.equals(flower))
				return flow;
		}
		return null;
	}

	public  Flower  addFlower(Flower f) {
		getFlowers().add(f);
		return f;
	}

	public static  FlowerBucket addFlowers(FlowerBucket bucket, List<Flower> list) {
		for (Flower flower : list) {
			bucket.addFlower(flower);
		}
		return bucket;
	}

	@Override
	public String toString() {
		String formattedString = getFlowers().toString()
			    .replace(",", "")  //remove the commas
			    .replace("[", "")  //remove the right bracket
			    .replace("]", "")  //remove the left bracket
			    .trim();           //remove trailing spaces from partially initialized arrays
		
		return "FlowerBucket description " + description + " price " + price + ".\n Flowers:\n " + formattedString + ".\n";
	}
	/**
	 * @return the flowers
	 */
	public  List<Flower> getFlowers() {
		return flowers;
	}
	/**
	 * @param flowers the flowers to set
	 */
	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}
	

}
