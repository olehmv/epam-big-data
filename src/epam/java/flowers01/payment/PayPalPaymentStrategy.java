package epam.java.flowers01.payment;

public class PayPalPaymentStrategy implements IPayment {
	
	@Override
	public double pay(double price) {
		double fee=price / 100 * 3;
		System.out.println("PayPal payment - "+fee+" processing...");
		return fee;
	}

	@Override
	public String toString() {
		return "PayPalPaymentStrategy";
	}
	
	

	

}
