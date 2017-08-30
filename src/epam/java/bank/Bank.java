package epam.java.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import epam.java.bank.client.Client;
import epam.java.bank.loan.Loan;

public class Bank implements IBank {
	private BankName name;
	private Map<Integer, Client> clients;
	private List<Loan> loans;

	public Bank(BankName name) {
		this.name = name;
		loans = new ArrayList<>();
		clients = new HashMap<>();
	}

	@Override
	public String getBankName() {
		return name.toString();
	}

	@Override
	public BankName getBankname() {
		return name;
	}

	@Override
	public List<Loan> getLoans() {
		return loans;
	}

	@Override
	public void setLoands(List<Loan> loans) {
		this.loans = loans;
	}

	@Override
	public void addLoan(Loan loan) {
		loans.add(loan);
	}

	@Override
	public Loan removeLoan(Loan loan) {
		loans.remove(loan);
		return loan;
	}

	@Override
	public Client getClient(Client client) {
		return clients.get(client.getId());
	}

	@Override
	public void addClient(Client client) {
		clients.put(client.getId(), client);
	}

	@Override
	public Map<Integer, Client> getCustomers() {
		return clients;
	}

	@Override
	public Loan processLoan(Client client) {
		Loan loan = client.getLoan();
		if (client.getName() == null || client.getIncome() == 0) {
			return loan;
		}
		for (Loan iLoan : loans) {
			if (client.getLoan().matchesRequirement(iLoan)) {
				loan.setDateOfIssue(LocalDateTime.now());
				loan.setBank(iLoan.getBank());
				loan.setRate(iLoan.getRate());
				loan.calculatetPeriodPayment();
				clients.put(client.getId(), client);
			}
			;
		}
		return loan;
	}

	@Override
	public String toString() {

		return "Bank name:" + name + "\n";
	}

	/**
	 * change loan only if client is in bank's clients list
	 */
	@Override
	public Loan changeLoan(Client c) {
		Loan loan = c.getLoan();
		Set<Entry<Integer, Client>> set = clients.entrySet();
		for (Entry<Integer, Client> entry : set) {
			if (c.getId() == entry.getKey()) {
				loan = entry.setValue(c).getLoan();
			}
		}

		return loan;
	}

	@Override
	public Loan payLoan(Client c, double sum) {
		Loan loan = c.getLoan();
		Set<Entry<Integer, Client>> set = clients.entrySet();
		for (Entry<Integer, Client> entry : set) {
			if (c.getId() == entry.getKey()) {
				double rmd = entry.getValue().getLoan().getRemainderPayment() - sum;
				if (rmd <= 0) {
					loan = entry.getValue().getLoan().closeLoan();
					clients.remove(entry.getKey(), entry.getValue());
				} else {
					if (sum >= entry.getValue().getLoan().getMonthInterest()
							+ entry.getValue().getLoan().getMonthPayment()) {
						entry.getValue().getLoan()
								.setRemainderPayment(rmd - entry.getValue().getLoan().getMonthInterest());
						entry.getValue().getLoan().setMonthInterest(0);
						entry.getValue().getLoan().setMonthPayment(0);
					} else {
						entry.getValue().getLoan().setRemainderPayment(rmd);
						entry.getValue().getLoan().calculateMonthPayment();
						loan = entry.getValue().getLoan();
					}

				}
			}
		}
		return loan;
	}

}
