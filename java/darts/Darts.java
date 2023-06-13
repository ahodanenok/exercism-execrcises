/**
 * Darts
 * https://exercism.org/tracks/java/exercises/darts
 */
class Darts {

    private static final double INNER_CIRCLE_R2 = 1.0;
    private static final double MIDDLE_CIRCLE_R2 = 25.0;
    private static final double OUTER_CIRCLE_R2 = 100.0;

    int score(double xOfDart, double yOfDart) {
        double r2 = xOfDart * xOfDart + yOfDart * yOfDart;
        if (r2 <= INNER_CIRCLE_R2) {
            return 10;
        } else if (r2 <= MIDDLE_CIRCLE_R2) {
            return 5;
        } else if (r2 <= OUTER_CIRCLE_R2) {
            return 1;
        } else {
            return 0;
        }
    }
}
