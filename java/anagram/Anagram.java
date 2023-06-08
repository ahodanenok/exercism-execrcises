import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Anagram
 * https://exercism.org/tracks/java/exercises/anagram
 */
public class Anagram {

    private final String word;
    private final char[] fingerprint;

    public Anagram(String word) {
        this.word = word;
        this.fingerprint = getFingerprint(word);
    }

    public List<String> match(List<String> candidates) {
        List<String> matches = new ArrayList<>();
        for (String candidate : candidates) {
            if (!word.equalsIgnoreCase(candidate)
                    && Arrays.equals(fingerprint, getFingerprint(candidate))) {
                matches.add(candidate);
            }
        }

        return matches;
    }

    private char[] getFingerprint(String word) {
        char[] letters = word.toLowerCase().toCharArray();
        Arrays.sort(letters);

        return letters;
    }
}
