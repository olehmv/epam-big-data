package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Bouquet {

	
	@Override
	public String toString() {
		return "Bouquet" + date + "[flowers=" + flowers + ", date=" + date + "]";
	}
	private List<Flower> flowers;
	private Date date;
	public Bouquet(List <Flower> flowers) {
		this.flowers=flowers;
		this.setDate(new Date());
	}


	public List<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}
	
	
	public BigDecimal getSum() {
		int sum=0;
		for (Flower flower : flowers) {
			sum=sum + flower.getPrice().intValue();
		}
		return new BigDecimal(sum);
	}
	public Flower getLongest() {
		double longest=Double.MIN_VALUE;
		Flower flower=null;
		for (Flower flow : flowers) {
			if(flow.getLength()>longest) {
				longest=flow.getLength();
				flower=flow;
			}
		}
		return flower;
	}

	public Date getDate() {
		return date;
	}
	private void setDate(Date date) {
		this.date=date;
	}

	
	
	
	
}
