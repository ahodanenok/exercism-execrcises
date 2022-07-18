/**
 * Scrabble Score
 * https://exercism.org/tracks/java/exercises/scrabble-score
 */
class Scrabble {

    private final int score;

    Scrabble(String word) {
        this.score = calculateScore(word);
    }

    private int calculateScore(String word) {
        if (word.isEmpty()) {
            return 0;
        }

        int score = 0;
        for (char ch : word.toLowerCase().toCharArray()) {
            if (characterOneOf(ch, "aeioulnrst")) {
                score += 1;
            } else if (characterOneOf(ch, "dg")) {
                score += 2;
            } else if (characterOneOf(ch, "bcmp")) {
                score += 3;
            } else if (characterOneOf(ch, "fhvwy")) {
                score += 4;
            } else if (ch == 'k') {
                score += 5;
            } else if (characterOneOf(ch, "jx")) {
                score += 8;
            } else if (characterOneOf(ch, "qz")) {
                score += 10;
            } else {
                // ignore any other character
            }
        }

        return score;
    }

    private boolean characterOneOf(char ch, String characters) {
        return characters.indexOf(ch) >= 0;
    }

    int getScore() {
        return score;
    }
}
