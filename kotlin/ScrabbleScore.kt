/**
 * https://exercism.io/my/tracks/kotlin
 * Scrabble Score
 */

object ScrabbleScore_1 {

    private fun scoreLetter(c: Char): Int {
        return when (c.toUpperCase()) {
            in "AEIOULNRST" -> 1
            in "DG" -> 2
            in "BCMP" -> 3
            in "FHVWY" -> 4
            'K' -> 5
            in "JX" -> 8
            in "QZ" -> 10
            else -> 0
        }
    }

    fun scoreWord(word: String): Int = word.sumBy(::scoreLetter)
}

object ScrabbleScore_2 {

    private val scores: Map<Char, Int> = mapOf(
        "AEIOULNRST" to 1,
        "DG" to 2,
        "BCMP" to 3,
        "FHVWY" to 4,
        "K" to 5,
        "JX" to 8,
        "QZ" to 10
    ).entries.fold(mutableMapOf()) { map, entry ->
        entry.key.toCharArray().map { map[it] = entry.value }
        map
    }

    private fun scoreLetter(c: Char): Int {
        return scores.getOrDefault(c.toUpperCase(), 0)
    }

    fun scoreWord(word: String): Int = word.sumBy(::scoreLetter)
}
