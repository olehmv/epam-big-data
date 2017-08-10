package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Flower implements Type {
	protected Date date;
	protected BigDecimal price;
	protected double length;
	protected Type type;
	protected boolean isInBowl;

	

	public Flower(Date date, BigDecimal price, double length, Type type, boolean isInBowl) {
		super();
		this.date = date;
		this.price = price;
		this.length = length;
		this.type = type;
		this.isInBowl = isInBowl;
	}

	@Override
	public List<Type> getSubTypes() {
		return type.getSubTypes();
	}

	@Override
	public Type getSyperType() {
		return type.getSyperType();
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isInBowl() {
		return isInBowl;
	}

	public void setInBowl(boolean isInBowl) {
		this.isInBowl = isInBowl;
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

	@Override
	public String toString() {
		return "Flower [date=" + date + ", price=" + price + ", length=" + length + ", type="+type.getClass().getSimpleName()+"." + type + ", isInBowl="
				+ isInBowl + "]\n";
	}
	
	
	
	

}
