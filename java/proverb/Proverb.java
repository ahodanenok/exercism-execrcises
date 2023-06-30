import java.util.StringJoiner;

/**
 * Proverb
 * https://exercism.org/tracks/java/exercises/proverb
 */
class Proverb {

    private static final String LINE = "For want of a %s the %s was lost.";
    private static final String END_LINE = "And all for the want of a %s.";

    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        if (words.length == 0) {
            return "";
        }

        StringJoiner joiner = new StringJoiner("\n");
        for (int i = 0, length = words.length - 1; i < length; i++) {
            joiner.add(String.format(LINE, words[i], words[i + 1]));
        }
        joiner.add(String.format(END_LINE, words[0]));

        return joiner.toString();
    }
}
