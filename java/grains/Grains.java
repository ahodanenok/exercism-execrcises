import java.math.BigInteger;

/**
 * Grains
 * https://exercism.org/tracks/java/exercises/grains
 */
class Grains {

    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final int SQUARE_COUNT = 64;

    BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > SQUARE_COUNT) {
            throw new IllegalArgumentException("square must be between 1 and " + SQUARE_COUNT);
        }

        return TWO.pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        BigInteger grainsCount = BigInteger.ZERO;
        for (int square = 1; square <= SQUARE_COUNT; square++) {
            grainsCount = grainsCount.add(grainsOnSquare(square));
        }

        return grainsCount;
    }
}
