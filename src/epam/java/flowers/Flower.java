package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Flower {
	enum FlowerType{
		Subtropical,Temperate
		
	}
	protected Date cutTime=new Date();
	protected BigDecimal price;
	protected double length;
	protected FlowerType type;
	public Flower(Date cutTime, BigDecimal price, double length, FlowerType flowerType) {
		this.cutTime = cutTime;
		this.price = price;
		this.length = length;
		this.type = type;
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
	public FlowerType getType() {
		return type;
	}
	public void setType(FlowerType type) {
		this.type = type;
	}
	
	
	

}
