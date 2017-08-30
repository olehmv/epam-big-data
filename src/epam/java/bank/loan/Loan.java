package epam.java.bank.loan;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDateTime;
import java.time.Period;

import epam.java.bank.IBank;

public class Loan {
	private LoanForm form;
	private Period period;
	private double remainderPayment;
	private double periodPayment;
	private double periodInterest;
	private double monthInterest;
	private double monthPayment;
	private IBank bank;
	private double rate;
	private LocalDateTime dateOfIssue;

	public boolean matchesRequirement(Loan l) {
		if (this.getLoanForm() != l.getLoanForm()) {
			return false;
		}
		return true;
	}

	public Loan(LoanForm form, long rate) {
		this.setForm(form);
		this.rate = rate / 100;
	}

	public Loan(LoanForm form) {
		this(form, 1);
	}

	public String getLoanForm() {
		return getForm().toString();
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public double calculateMonthPayment() {
		double days = LocalDateTime.now().getDayOfMonth();
		setMonthInterest(days * rate * remainderPayment);
		setMonthPayment(getMonthInterest() + remainderPayment / period.getMonths());
		return getMonthPayment();
	}

	public void calculatetPeriodPayment() {
		LocalDateTime dateAfter = dateOfIssue.plus(period);
		long daysBetween = DAYS.between(dateOfIssue, dateAfter);
		periodPayment = daysBetween * rate * remainderPayment + remainderPayment;
		periodInterest = periodPayment - remainderPayment;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate / 100;
	}

	@Override
	public String toString() {
		return "Loan form: " + form + " period: " + period + " remainderPayment: " + remainderPayment
				+ " periodPayment: " + periodPayment + " periodInterest: " + periodInterest+" monthPayment: " + getMonthPayment()+" monthinterest: "
				+ getMonthInterest() + ", bank: " + bank + " rate: " + rate + ", dateOfIssue: " + dateOfIssue + "\n";
	}

	public IBank getBank() {
		return bank;
	}

	public void setBank(IBank bank) {
		this.bank = bank;
	}

	public LoanForm getForm() {
		return form;
	}

	public void setForm(LoanForm form) {
		this.form = form;
	}

	public LocalDateTime getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(LocalDateTime dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public void setRemainderPayment(double remainderPayment) {
		this.remainderPayment = remainderPayment;
	}

	public double getRemainderPayment() {
		return remainderPayment;
	}

	/**
	 * @return the monthInterest
	 */
	public double getMonthInterest() {
		return monthInterest;
	}

	/**
	 * @param monthInterest
	 *            the monthInterest to set
	 */
	public void setMonthInterest(double monthInterest) {
		this.monthInterest = monthInterest;
	}

	public Loan closeLoan() {
		remainderPayment = 0;
		monthInterest = 0;
		return this;
	}

	/**
	 * @return the monthPayment
	 */
	public double getMonthPayment() {
		return monthPayment;
	}

	/**
	 * @param monthPayment the monthPayment to set
	 */
	public void setMonthPayment(double monthPayment) {
		this.monthPayment = monthPayment;
	}

}
