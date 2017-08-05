package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;

public class Bougainvillea extends Flower {


	public Bougainvillea(Date cutTime, BigDecimal price, double length, Type type) {
		super(cutTime, price, length, type);
		
	}

	@Override
	public String toString() {
		return "Bougainvillea [cutTime=" + cutTime + ", price=" + price + ", length=" + length + " type="+ superType+"."+getClass().getSimpleName() 
				+"." + type + "]\n";
	}
}
