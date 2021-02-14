/**
 * https://exercism.io/my/tracks/kotlin
 * Crypto Square
 */

import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        val text = plaintext.replace(Regex("[^a-zA-Z0-9]"), "")

        val r = sqrt(text.length.toDouble()).toInt()
        val (rows, cols) = when {
            r * r >= text.length -> r to r
            (r + 1) * r >= text.length -> r to (r + 1)
            else -> (r + 1) to (r + 1)
        }

        val sb = StringBuilder()
        for (col in 0 until cols) {
            for (row in 0 until rows) {
                sb.append(text.getOrElse(cols * row + col) { ' ' }.toLowerCase())
            }

            if (col < cols - 1) {
                sb.append(' ')
            }
        }

        return sb.toString()
    }
}
