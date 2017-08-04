package epam.java.flowers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Bouquet {

	
	@Override
	public String toString() {
		String formattedString = flowers.toString()
			    .replace(",", "")  //remove the commas
			    .replace("[", "")  //remove the right bracket
			    .replace("]", "")  //remove the left bracket
			    .trim();           //remove trailing spaces from partially initialized arrays
		return "Bouquet of "+flowers.size()+"flowers\n"+"Date: "+ date +"\n "+"Flowers:\n " + formattedString + "]";
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
