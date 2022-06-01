/**
 * Blackjack
 * https://exercism.org/tracks/java/exercises/blackjack
 */
public class Blackjack {

    public int parseCard(String card) {
        if ("two".equals(card)) {
            return 2;
        } else if ("three".equals(card)) {
            return 3;
        } else if ("four".equals(card)) {
            return 4;
        } else if ("five".equals(card)) {
            return 5;
        } else if ("six".equals(card)) {
            return 6;
        } else if ("seven".equals(card)) {
            return 7;
        } else if ("eight".equals(card)) {
            return 8;
        } else if ("nine".equals(card)) {
            return 9;
        } else if ("ten".equals(card)) {
            return 10;
        } else if ("jack".equals(card)) {
            return 10;
        } else if ("queen".equals(card)) {
            return 10;
        } else if ("king".equals(card)) {
            return 10;
        } else if ("ace".equals(card)) {
            return 11;
        } else {
            return 0;
        }
    }

    public boolean isBlackjack(String card1, String card2) {
        return (parseCard(card1) + parseCard(card2)) == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if (!isBlackjack || dealerScore == 10 || dealerScore == 11) {
            return "S";
        } else {
            return "W";
        }
    }

    public String smallHand(int handScore, int dealerScore) {
        if (handScore >= 17) {
            return "S";
        } else if (handScore <= 11 || dealerScore >= 7) {
            return "H";
        } else {
            return "S";
        }
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            // split aces, can't implement this check in largeHand because no access to this score
            if (handScore == 22) {
                return "P";
            }
        
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
