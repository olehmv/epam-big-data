package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;

public class Daffodils extends Flower {

	public Daffodils(Date cutTime, BigDecimal price, double length, Type type) {
		super(cutTime, price, length, type);

	}

	@Override
	public String toString() {
		return "Daffodils [cutTime=" + cutTime + ", price=" + price + ", length=" + length + " type=" + superType+"."+getClass().getSimpleName()
				+ "." + type + "]\n";
	}

	
}
