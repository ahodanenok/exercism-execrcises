import java.util.HashMap;
import java.util.Map;

/**
 * Word Count
 * https://exercism.org/tracks/java/exercises/word-count
 */
class WordCount {

    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> counts = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else if (ch == '\'') {
                sb.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            } else if (sb.length() > 0) {
                counts.merge(normalize(sb), 1, Integer::sum);
                sb.setLength(0);
            } else {
                // skip
            }
        }

        if (sb.length() > 0) {
            counts.merge(normalize(sb), 1, Integer::sum);
        }

        return counts;
    }

    private String normalize(StringBuilder word) {
        int from = 0;
        int to = word.length();

        if (word.charAt(0) == '\'') {
            from++;
        }
        if (word.charAt(word.length() - 1) == '\'') {
            to--;
        }

        return word.substring(from, to).toLowerCase();
    }
}
