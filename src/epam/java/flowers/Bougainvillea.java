package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;

public class Bougainvillea extends Flower {


	public Bougainvillea(Date cutTime, BigDecimal price, double length, FlowerType flowerType) {
		super(cutTime, price, length, flowerType);
	}

	@Override
	public String toString() {
		return "Bougainvillea [cutTime=" + cutTime + ", price=" + price + ", length=" + length + ", type=" + type + "]\n";
	}


	
	

	

}
