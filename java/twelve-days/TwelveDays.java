import java.util.StringJoiner;

/**
 * Twelve Days
 * https://exercism.org/tracks/java/exercises/twelve-days
 */
class TwelveDays {

    private static final String VERSE = "On the %s day of Christmas my true love gave to me: %s.\n";

    private static final String[] DAYS = {
        "first",
        "second",
        "third",
        "fourth",
        "fifth",
        "sixth",
        "seventh",
        "eighth",
        "ninth",
        "tenth",
        "eleventh",
        "twelfth"
    };

    private static final String[] PRESENTS = {
        "a Partridge in a Pear Tree",
        "two Turtle Doves",
        "three French Hens",
        "four Calling Birds",
        "five Gold Rings",
        "six Geese-a-Laying",
        "seven Swans-a-Swimming",
        "eight Maids-a-Milking",
        "nine Ladies Dancing",
        "ten Lords-a-Leaping",
        "eleven Pipers Piping",
        "twelve Drummers Drumming"
    };

    String verse(int verseNumber) {
        StringJoiner presents = new StringJoiner(", ");
        for (int p = verseNumber - 1; p > 0; p--) {
            presents.add(PRESENTS[p]);
        }
        if (presents.length() > 0) {
            presents.add("and " + PRESENTS[0]);
        } else {
            presents.add(PRESENTS[0]);
        }

        return String.format(VERSE, DAYS[verseNumber - 1], presents);
    }

    String verses(int startVerse, int endVerse) {
        StringJoiner joiner = new StringJoiner("\n");
        for (int v = startVerse; v <= endVerse; v++) {
            joiner.add(verse(v));
        }

        return joiner.toString();
    }

    String sing() {
        return verses(1, 12);
    }
}
