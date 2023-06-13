import java.util.Map;

/**
 * Resistor Color Duo
 * https://exercism.org/tracks/java/exercises/resistor-color-duo
 */
class ResistorColorDuo {

    private static final Map<String, Integer> ENCODING = Map.of(
        "black",  0,
        "brown",  1,
        "red",    2,
        "orange", 3,
        "yellow", 4,
        "green",  5,
        "blue",   6,
        "violet", 7,
        "grey",   8,
        "white",  9
    );

    int value(String[] colors) {
        return 10 * ENCODING.get(colors[0]) + ENCODING.get(colors[1]);
    }
}
