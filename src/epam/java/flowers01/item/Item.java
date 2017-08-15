package epam.java.flowers01.item;

public abstract class Item {
	protected String description;
	protected double price;
	public Item(){
		
	}
	public Item(String description, double price) {
		super();
		this.description = description;
		this.price = price;
	}


	public String getDescription() {
		return description;
	}
	
	
	public abstract double price();






	
	
	
}
