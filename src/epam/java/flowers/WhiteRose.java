package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;

public class WhiteRose extends Rose {

	

	public WhiteRose(Date cutTime, BigDecimal price, double length, FlowerType flowerType) {
		super(cutTime, price, length, flowerType);
	}

	@Override
	public String toString() {
		return "WriteRose [cutTime=" + cutTime + ", price=" + price + ", length=" + length +  "]";
	}

}
