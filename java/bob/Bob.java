/**
 * Bob
 * https://exercism.org/tracks/java/exercises/bob
 */
public class Bob {

    public String hey(String phrase) {
        String trimmed = phrase.trim();
        if (trimmed.isEmpty()) {
            return "Fine. Be that way!";
        }

        boolean question = trimmed.charAt(trimmed.length() - 1) == '?';
        boolean uppercase = isUpperCase(trimmed);
        if (question && uppercase) {
            return "Calm down, I know what I'm doing!";
        } else if (uppercase) {
            return "Whoa, chill out!";
        } else if (question) {
            return "Sure.";
        } else {
            return "Whatever.";
        }
    }

    private boolean isUpperCase(String phrase) {
        boolean atLeastOneUppercase = false;
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            if (Character.isUpperCase(ch)) {
                atLeastOneUppercase = true;
                continue;
            }

            if (!Character.isLetter(ch)) {
                continue;
            }

            return false; // letter and is not uppercase
        }

        return atLeastOneUppercase;
    }
}
