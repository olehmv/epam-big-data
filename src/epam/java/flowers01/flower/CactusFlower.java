package epam.java.flowers01.flower;

public class CactusFlower extends Flower {

	public CactusFlower(boolean fresh, double price, FlowerSpec spec) {
		super(fresh, price, spec);
	}

	@Override
	public double price() {
		return price;
	}

}
