package epam.java.bank;

import epam.java.bank.client.Client;
import epam.java.bank.loan.Loan;

public interface ILoanHandler {
	
	Loan processLoan(Client client);
	Loan payLoan(Client c,double sum);
	Loan changeLoan(Client c);
}
