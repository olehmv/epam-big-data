package epam.java.flowers01.flower;

/**
 * Created by вова on 14.10.2016.
 */
public enum FlowerColor {

	GREEN, RED, BLUE, BLACK, WHITE;

	public String toString() {

		switch (this) {
		case GREEN:
			return "Green";
		case RED:
			return "Red";
		case BLUE:
			return "Blue";
		case BLACK:
			return "Black";
		case WHITE:
			return "White";
		default:
			return "no color";
		}

	}

}
