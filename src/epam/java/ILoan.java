package epam.java;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDateTime;
import java.time.Period;

import epam.java.bank.IBank;
import epam.java.bank.loan.LoanForm;

public interface ILoan {

	void setDateOfIssue(LocalDateTime dateOfIssue);

	LocalDateTime getDateOfIssue();

	void setForm(LoanForm form);

	LoanForm getForm();

	void setBank(IBank bank);

	IBank getBank();

	void setRate(long rate);

	long getRate();

	void setRemainderPayment(double remainderSum);

	double getRemainderPayment();

	double getMonthPayment();

	void setPeriod(Period period);

	Period getPeriod();

	String getLoanForm();

	boolean matchesRequirement(ILoan l);

	double getInterest();

	void setInterest(double interest);

	void calculatetPeriodPayment();

}
