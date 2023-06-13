import java.util.Arrays;

/**
 * Resistor Color
 * https://exercism.org/tracks/java/exercises/resistor-color
 */
class ResistorColor {

    private static final String[] ENCODING = {
        "black",
        "brown",
        "red",
        "orange",
        "yellow",
        "green",
        "blue",
        "violet",
        "grey",
        "white"
    };

    int colorCode(String color) {
        for (int i = 0; i < ENCODING.length; i++) {
            if (color.equals(ENCODING[i])) {
                return i;
            }
        }

        return -1;
    }

    String[] colors() {
        return Arrays.copyOf(ENCODING, ENCODING.length);
    }
}
