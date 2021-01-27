/**
 * https://exercism.io/my/tracks/kotlin
 * Darts
 */

import kotlin.math.pow

object Darts_1 {

    fun score(x: Number, y: Number): Int {
        val r2 = x.toDouble().pow(2.0) + y.toDouble().pow(2.0)
        return when {
            r2 <= 1 -> 10
            r2 <= 25 -> 5
            r2 <= 100 -> 1
            else -> 0
        }
    }
}

object Darts_2 {

    private val scores = listOf(1 to 10, 25 to 5, 100 to 1)

    fun score(x: Number, y: Number): Int {
        val r2 = x.toDouble().pow(2.0) + y.toDouble().pow(2.0)
        return scores.firstOrNull { r2 <= it.first }?.second ?: 0
    }
}
