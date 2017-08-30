package epam.java.bank.loan;

import java.util.ArrayList;
import java.util.List;

import epam.java.bank.BankFactory;
import epam.java.bank.BankName;
import epam.java.bank.IBank;
import epam.java.bank.ILoanHandler;
import epam.java.bank.client.Client;

public final class LoanBureau implements ILoanHandler {

	private IBank[] loanhandlers;

	public LoanBureau(IBank... loanhandlers) {
		super();
		this.loanhandlers = loanhandlers;
	}

	public LoanBureau() {
		IBank creditbank = BankFactory.createBank(BankName.CREDIT_BANK);
		IBank oschadbank = BankFactory.createBank(BankName.OSCHAD_BANK);
		IBank privatebank = BankFactory.createBank(BankName.PRIVAT_BANK);
		Loan carloan = LoanFactory.createLoan(LoanForm.CAR_LOAN);
		Loan crediteLine = LoanFactory.createLoan(LoanForm.CREDITE_LINE);
		Loan homeloan = LoanFactory.createLoan(LoanForm.HOME_LOAN);

		homeloan.setRate(20);
		homeloan.setBank(creditbank);

		crediteLine.setRate(3);
		crediteLine.setBank(creditbank);

		carloan.setRate(5);
		carloan.setBank(creditbank);

		creditbank.addLoan(crediteLine);
		creditbank.addLoan(carloan);
		creditbank.addLoan(homeloan);
		
		
		Loan carloan1 = LoanFactory.createLoan(LoanForm.CAR_LOAN);
		Loan crediteLine1 = LoanFactory.createLoan(LoanForm.CREDITE_LINE);
		Loan homeloan1 = LoanFactory.createLoan(LoanForm.HOME_LOAN);
		homeloan1.setRate(30);
		homeloan1.setBank(oschadbank);

		crediteLine1.setRate(6);
		crediteLine1.setBank(oschadbank);

		carloan1.setRate(10);
		carloan1.setBank(oschadbank);

		oschadbank.addLoan(crediteLine1);
		oschadbank.addLoan(carloan1);
		oschadbank.addLoan(homeloan1);
		
		
		Loan carloan2 = LoanFactory.createLoan(LoanForm.CAR_LOAN);
		Loan crediteLine2 = LoanFactory.createLoan(LoanForm.CREDITE_LINE);
		Loan homeloan2 = LoanFactory.createLoan(LoanForm.HOME_LOAN);
		
		homeloan2.setRate(30);
		homeloan2.setBank(privatebank);

		crediteLine2.setRate(9);
		crediteLine2.setBank(privatebank);

		carloan2.setRate(15);
		carloan2.setBank(privatebank);

		privatebank.addLoan(carloan2);
		privatebank.addLoan(crediteLine2);
		privatebank.addLoan(homeloan2);
		loanhandlers = new IBank[] { creditbank, oschadbank, privatebank };

	}

	public String showLoanHadlers() {
		StringBuilder b = new StringBuilder();
		for (IBank iLoanHandler : loanhandlers) {
			b.append("\n" + iLoanHandler.toString() + " ");
			String string = iLoanHandler.getLoans().toString().replace("[", "").replace("]", "").replace(",", "");
			b.append(string);
		}
		return b.toString();

	}

	@Override
	public Loan processLoan(Client client) {
		for (IBank iBank : loanhandlers) {
			client.setLoan(iBank.processLoan(client));
			if (client.getLoan().getDateOfIssue() != null) {
				break;
			}
		}
		return client.getLoan();
	}

	/**
	 * goes through banks and change client loan
	 */
	@Override
	public Loan changeLoan(Client c) {
		for (IBank iBank : loanhandlers) {
			c.setLoan(iBank.changeLoan(c));
		}
		return c.getLoan();
	}

	@Override
	public Loan payLoan(Client c, double sum) {
		for (IBank iBank : loanhandlers) {
			c.setLoan(iBank.payLoan(c, sum));
		}
		return c.getLoan();
	}

	public IBank[] getBanks() {
		return loanhandlers;
	}

	public List<Loan> findLoans(LoanForm form) {
		List<Loan> list = new ArrayList<>();
		for (IBank iBank : loanhandlers) {
			for (Loan l : iBank.getLoans()) {
				if (l.getForm().equals(form)) {
					list.add(l);
				}
			}
		}
		return list;
	}

}
