package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;

public class Peonies extends Flower {
	

	public Peonies(Date cutTime, BigDecimal price, double length, FlowerType flowerType) {
		super(cutTime, price, length, flowerType);
	}

	@Override
	public String toString() {
		return "Peonies [cutTime=" + cutTime + ", price=" + price + ", length=" + length + ", type=" + type + "]\n";
	}

	
	

}
