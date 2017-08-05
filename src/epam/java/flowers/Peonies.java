package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;

public class Peonies extends Flower {
	

	public Peonies(Date cutTime, BigDecimal price, double length, Type type) {
		super(cutTime, price, length, type);
		
	}

	@Override
	public String toString() {
		return "Peonies [cutTime=" + cutTime + ", price=" + price + ", length=" + length + " type=" + superType+"."+getClass().getSimpleName()
				+ "." + type + "]\n";
	}

	
	

}
