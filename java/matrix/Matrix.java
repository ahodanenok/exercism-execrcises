/**
 * Matrix
 * https://exercism.org/tracks/java/exercises/matrix
 */
class Matrix {

    private final String[] rows;

    Matrix(String matrixAsString) {
        this.rows = matrixAsString.split("\n");
    }

    int[] getRow(int rowNumber) {
        int rowIndex = rowNumber - 1;
        String[] numbers = rows[rowIndex].split(" ");
        int[] row = new int[numbers.length];
        for (int columnIndex = 0; columnIndex < numbers.length; columnIndex++) {
            row[columnIndex] = Integer.parseInt(numbers[columnIndex].trim());
        }

        return row;
    }

    int[] getColumn(int columnNumber) {
        int columnIndex = columnNumber - 1;
        int[] column = new int[rows.length];
        for (int rowIndex = 0; rowIndex < rows.length; rowIndex++) {
            column[rowIndex] = getRow(rowIndex + 1)[columnIndex];
        }

        return column;
    }
}
