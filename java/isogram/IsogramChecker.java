/**
 * Isogram
 * https://exercism.org/tracks/java/exercises/isogram
 */
class IsogramChecker {

    boolean isIsogram(String phrase) {
        String str = phrase.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ' || ch == '-') {
                continue;
            }

            if (str.indexOf(ch, i + 1) >= 0) {
                return false;
            }
        }

        return true;
    }
}
