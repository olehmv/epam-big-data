package epam.java.flowers.extra;
/**
 * Created by вова on 14.10.2016.
 */
public enum FlowerColor {

    GREEN, RED, BLUE, BLACK;

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
            default:
                return "no color";
        }

    }

}
