package epam.java.flowers01.payment;

public class CreditCartPaymentStrategy implements IPayment {

	@Override
	public double pay(double price) {
		double fee=price / 100 * 5;
		System.out.println("Processing Creadit Cart payment - "+fee+" payment ...");
		return fee;
	}

	@Override
	public String toString() {
		return "CreditCartPaymentStrategy";
	}

	

	

}
