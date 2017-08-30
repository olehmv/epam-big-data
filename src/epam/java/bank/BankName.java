package epam.java.bank;

public enum BankName {
	PRIVAT_BANK,OSCHAD_BANK,CREDIT_BANK;
	
	public String toString() {
		switch (this) {
		case PRIVAT_BANK:
			return "PRIVATE_BANK";
		case OSCHAD_BANK:
			return "OSCHAD_BANK";
		case CREDIT_BANK:
			return "CREDITE_BANK";
		default:
			return "undefine";	
		}

	}

}
