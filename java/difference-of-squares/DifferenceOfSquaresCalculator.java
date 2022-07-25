/**
 * Difference Of Squares
 * https://exercism.org/tracks/java/exercises/difference-of-squares
 */
class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = 0;
        for (int n = 1; n <= input; n++) {
            sum += n;
        }

        return sum * sum;
    }

    int computeSumOfSquaresTo(int input) {
        int sum = 0;
        for (int n = 1; n <= input; n++) {
            sum += (n * n);
        }

        return sum;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }
}
