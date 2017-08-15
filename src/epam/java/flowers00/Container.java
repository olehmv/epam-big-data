package epam.java.flowers00;

import java.math.BigDecimal;

public class Container {
	private ContainerType type;
	private Color color;
	private int size;
	private BigDecimal price;
	public Container(BigDecimal price, int size, ContainerType type, Color color) {
		super();
		this.price = price;
		this.size = size;
		this.type = type;
		this.color = color;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ContainerType getType() {
		return type;
	}
	public void setType(ContainerType type) {
		this.type = type;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Container [type=" + type + ", color=" + color + ", size=" + size + ", price=" + price + "]";
	}
	
	
	
	

}
