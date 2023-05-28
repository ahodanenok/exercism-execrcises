import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Saddle Points
 * https://exercism.org/tracks/java/exercises/saddle-points
 */
class Matrix {

    private final List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> points = new HashSet<>();
        for (int rowIdx = 0; rowIdx < values.size(); rowIdx++) {
            List<Integer> row = values.get(rowIdx);
            Integer max = Collections.max(row, Comparator.naturalOrder());
            for (int colIdx = 0; colIdx < row.size(); colIdx++) {
                Integer min = Integer.MAX_VALUE;
                for (int i = 0; i < values.size(); i++) {
                    Integer value = values.get(i).get(colIdx);
                    if (value < min) {
                        min = value;
                    }
                }

                if (max == min) {
                    points.add(new MatrixCoordinate(rowIdx + 1, colIdx + 1));
                }
            }
        }

        return points;
    }
}

// provided
class MatrixCoordinate implements Comparable<MatrixCoordinate> {
    private final int row;
    private final int col;

    MatrixCoordinate(final int row, final int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Row: " + row + ", Column: " + col;
    }

    // Generated equals and hashcode.

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final MatrixCoordinate that = (MatrixCoordinate) o;

        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public int compareTo(MatrixCoordinate o) {
        int rowComparison = Integer.compare(row, o.row);
        return (rowComparison == 0) ? Integer.compare(col, o.col) : rowComparison;
    }
}

