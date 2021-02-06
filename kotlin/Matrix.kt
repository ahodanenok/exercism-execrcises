/**
 * https://exercism.io/my/tracks/kotlin
 * Matrix
 */

class Matrix(matrixAsString: String) {

    private val matrix = matrixAsString.split(Regex("\\n")).map {
        it.trim().split(Regex("\\s+")).map { s -> s.toInt() }
    }

    fun column(col: Int): List<Int> {
        return matrix.map { it[col - 1] }
    }

    fun row(row: Int): List<Int> {
        return matrix[row - 1]
    }
}
