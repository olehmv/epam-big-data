package epam.java.bank.loan;

public enum LoanForm {
	CREDITE_LINE,HOME_LOAN,CAR_LOAN;
	
	public String toString() {
		switch (this) {
		case CREDITE_LINE:
			return "Credite Line";
		case HOME_LOAN:
			return "Home Loan";
		case CAR_LOAN:
			return "Car Loan";
		default:
			return "Unspecified";	
		}

	}


}
