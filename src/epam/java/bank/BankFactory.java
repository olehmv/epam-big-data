package epam.java.bank;

public class BankFactory {

	private BankFactory() {
	};

	public static IBank createBank(BankName name) {
		switch (name) {
		case CREDIT_BANK:
			return new Bank(BankName.CREDIT_BANK);
		case OSCHAD_BANK:
			return new Bank(BankName.OSCHAD_BANK);
		case PRIVAT_BANK:
			return new Bank(BankName.PRIVAT_BANK);
		default:
			return null;
		}
	}

}
