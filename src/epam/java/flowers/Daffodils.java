package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;

public class Daffodils  extends Flower{
	
	public Daffodils(Date cutTime, BigDecimal price, double length, FlowerType flowerType) {
		super(cutTime, price, length, flowerType);
	}

	@Override
	public String toString() {
		return "Daffodils [cutTime=" + cutTime + ", price=" + price + ", length=" + length  + "]";
	}

	

}
