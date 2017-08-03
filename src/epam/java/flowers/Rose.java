package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;

public class Rose extends Flower {
	

	public Rose(Date cutTime, BigDecimal price, double length, FlowerType flowerType) {
		super(cutTime, price, length, flowerType);
	}

	@Override
	public String toString() {
		return "Rose [cutTime=" + cutTime + ", price=" + price + ", length=" + length +  "]";
	}

	
	
}
