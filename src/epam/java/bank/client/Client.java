package epam.java.bank.client;

import epam.java.bank.loan.Loan;

public class Client {
	private int id;
	private static int id_count = 0;
	private String name;
	private double income;
	private Loan loan;


	public Client(String name, double income) {
		super();
		this.name = name;
		this.income = income;
		id_count++;
		id = id_count;
	}


	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Client name: " + name + " income: " + income + " loan: " + getLoan() + "\n";
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

}
