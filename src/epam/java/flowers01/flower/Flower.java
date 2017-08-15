package epam.java.flowers01.flower;

import epam.java.flowers01.item.Item;

/**
 * Created by matt on 10/3/16.
 */
public abstract class Flower extends Item{

	protected boolean fresh;
	protected double price;
	protected FlowerSpec spec;

	public Flower(boolean fresh, double price, FlowerSpec spec) {
		this.fresh = fresh;
		this.price = price;
		this.spec = spec;
	}

	public FlowerSpec getSpec() {
		return spec;
	}
	@Override
	public abstract double price();

	public boolean isFresh() {
		return fresh;
	}

	public String toString() {
		return "Type: " + spec.getType() + " price is " + String.valueOf(price()) + " its color is "
				+ spec.getColor() + " fresh leve is " + String.valueOf(isFresh()) + " its height "
				+ String.valueOf(spec.getLength())+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (fresh ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((spec == null) ? 0 : spec.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flower other = (Flower) obj;
		if (fresh != other.fresh)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (spec == null) {
			if (other.spec != null)
				return false;
		} else if (!spec.equals(other.spec))
			return false;
		return true;
	}
	
	
	

}
