package epam.java.flowers01.flower;

public class RomashkaFlower extends Flower{

	public RomashkaFlower(boolean fresh, double price, FlowerSpec spec) {
		super(fresh, price, spec);
	}

	@Override
	public double price() {
		return price;
	}

}
