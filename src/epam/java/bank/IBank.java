package epam.java.bank;

import java.util.List;
import java.util.Map;

import epam.java.bank.client.Client;
import epam.java.bank.loan.Loan;

public interface IBank extends ILoanHandler{

	String getBankName();

	List<Loan> getLoans();

	void setLoands(List<Loan> loans);

	void addLoan(Loan loan);

	Loan removeLoan(Loan loan);

	Map<Integer, Client> getCustomers();

	void addClient(Client customer);

	Client getClient(Client client);

	BankName getBankname();

	
}
