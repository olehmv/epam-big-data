package epam.java.bank.loan;

public class LoanFactory {

	private LoanFactory() {
	};

	public static Loan createLoan(LoanForm form) {
		switch (form) {
		case CAR_LOAN:
			return new Loan(LoanForm.CAR_LOAN);
		case HOME_LOAN:
			return new Loan(LoanForm.HOME_LOAN);
		case CREDITE_LINE:
			return new Loan(LoanForm.CREDITE_LINE);
		default:
			return null;
		}
	}
}
