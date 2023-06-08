import java.util.StringJoiner;

/**
 * Pig Latin
 * https://exercism.org/tracks/java/exercises/pig-latin
 */
public class PigLatinTranslator {

    public String translate(String str) {
        String[] words = str.split(" ");
        StringJoiner result = new StringJoiner(" ");
        for (String word : words) {
            char first = word.charAt(0);
            if (isVowel(first)) {
                result.add(word + "ay");
            } else if (word.startsWith("xr") || word.startsWith("yt")) {
                result.add(word + "ay");
            } else if (word.startsWith("qu")) {
                result.add(word.substring(2) + "quay");
            } else if (isConsonant(first) && word.startsWith("qu", 1)) {
                result.add(word.substring(3) + first + "quay");
            } else {
                int consontantPrefixSize = 0;
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (!isConsonant(ch) || (consontantPrefixSize > 0 && ch == 'y')) {
                        break;
                    }

                    consontantPrefixSize++;
                }

                if (consontantPrefixSize > 0) {
                    result.add(word.substring(consontantPrefixSize) + word.substring(0, consontantPrefixSize) + "ay");
                } else {
                    result.add(word);
                }
            }
        }

        return result.toString();
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private boolean isConsonant(char ch) {
        return ch >= 'a' && ch <= 'z' && !isVowel(ch);
    }
}
