package epam.java.flowers00;

import java.math.BigDecimal;
import java.util.Date;

public class Flower implements Type {
	private Date date;
	private BigDecimal price;
	private double length;
	private Type type;
	private Container container;

	public Flower(Date date, BigDecimal price, double length, Type type, Container container) {
		super();
		this.date = date;
		this.price = price;
		this.length = length;
		this.type = type;
		this.setContainer(container);
	}
	public Flower(Date date, BigDecimal price, double length, Type type) {
		super();
		this.date = date;
		this.price = price;
		this.length = length;
		this.type = type;
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
	/**
	 * @return the container
	 */
	public Container getContainer() {
		return container;
	}
	/**
	 * @param container the container to set
	 */
	public void setContainer(Container container) {
		this.container = container;
	}
	@Override
	public String toString() {
		if(getContainer()==null){
			return "Flower [date=" + date + ", price=" + price + ", length=" + length + ", type=" + type.getSyperType()+"."+type.getType()+ "]\n";
		}
		return "Flower [date=" + date + ", price=" + price + ", length=" + length + ", type=" + type.getSyperType()+"."+type.getType() + ", in container= "
				+ container + "]\n";
	}

	
	
	
	
	
	
	
	

}
