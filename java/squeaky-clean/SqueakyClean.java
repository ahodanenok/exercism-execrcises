/**
 * Squeaky Clean
 * https://exercism.org/tracks/java/exercises/squeaky-clean
 */
class SqueakyClean {
    static String clean(String identifier) {
        if (identifier.isEmpty()) {
            return "";
        }

        StringBuilder cleanedIdentifier = new StringBuilder();
        for (int i = 0; i < identifier.length(); i++) {
            char currentChar = identifier.charAt(i);
            if (currentChar == ' ') {
                cleanedIdentifier.append('_');
            } else if (Character.isISOControl(currentChar)) {
                cleanedIdentifier.append("CTRL");
            } else if (currentChar >= 'α' && currentChar <= 'ω') {
                continue;
            } else if (!Character.isLetter(currentChar)) {
                continue;
            } else if (isKebabCase(identifier, i)) {
                // preceding cases remove hypnen and other unwanted characters
                cleanedIdentifier.append(Character.toUpperCase(currentChar));
            } else {
                cleanedIdentifier.append(currentChar);
            }
        }

        return cleanedIdentifier.toString();
    }

    private static boolean isKebabCase(String identifier, int index) {
        if (index == 0) {
            return false;
        }

        return Character.isLowerCase(identifier.charAt(index)) && identifier.charAt(index - 1) == '-';
    }
}
