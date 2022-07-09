/**
 * Two Fer
 * https://exercism.org/tracks/java/exercises/two-fer
 */
public class Twofer {

    private static final String MESSAGE = "One for %s, one for me.";

    public String twofer(String name) {
        if (name != null) {
            return String.format(MESSAGE, name);
        } else {
            return String.format(MESSAGE, "you");
        }
    }
}
