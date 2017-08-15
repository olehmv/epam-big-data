package epam.java.flowers01.flower;

/**
 * Created by вова on 14.10.2016.
 */
public enum FlowerType {

	ROMASHKA, MAK, ROZA, TULPAN, CACTUS;

	public String toString() {
		switch (this) {
		case ROMASHKA:
			return "Romashka";
		case MAK:
			return "Mak";
		case ROZA:
			return "Roza";
		case TULPAN:
			return "Tulpan";
		case CACTUS:
			return "Cactuse";
		default:
			return "no color";
		}

	}
}
