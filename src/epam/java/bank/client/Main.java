package epam.java.bank.client;

import java.time.Period;
import java.util.List;

import epam.java.bank.loan.Loan;
import epam.java.bank.loan.LoanBureau;
import epam.java.bank.loan.LoanFactory;
import epam.java.bank.loan.LoanForm;

public class Main {

	public static void main(String[] args) {
		LoanBureau b = new LoanBureau();
		System.out.println(b.showLoanHadlers());
		Client c = new Client("Ivan", 12000);
		Loan loan = LoanFactory.createLoan(LoanForm.CAR_LOAN);
		loan.setPeriod(Period.ofMonths(12));
		loan.setRemainderPayment(5000);
		c.setLoan(loan);
		System.out.println(b.processLoan(c));
		loan.setForm(LoanForm.CREDITE_LINE);
		System.out.println(b.changeLoan(c));
		c.getLoan().calculateMonthPayment();
		System.out.println(c);
		double pay = c.getLoan().getMonthInterest() + c.getLoan().getMonthPayment();
		b.payLoan(c, pay);
		System.out.println(c);
		List<Loan> loans = b.findLoans(LoanForm.HOME_LOAN);
		System.out.println("Found loans: \n "+loans.toString().replace("[","").replace("]", "").replace(",", ""));
		c.setLoan(loans.get(0));
		
		System.out.println(c);
	}

}
