package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract class Flower implements Type {
	protected Date cutTime;;
	protected BigDecimal price;
	protected double length;
	protected Type superType;
	protected Type type;

	public Flower(Date cutTime, BigDecimal price, double length, Type type) {
		this.cutTime = cutTime;
		this.price = price;
		this.length = length;
		this.setSuperType(type.getSyperType());
		this.setType(type);
	}
	@Override
	public List<Type> getSubTypes() {
		return type.getSubTypes();
	}
	@Override
	public Type getSyperType() {
		return superType;
	}
	public Date getCutTime() {
		return cutTime;
	}

	public void setCutTime(Date cutTime) {
		this.cutTime = cutTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public void setSuperType(Type superType) {
		this.superType = superType;
	}
}
