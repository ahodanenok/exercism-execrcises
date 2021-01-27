/**
 * https://exercism.io/my/tracks/kotlin
 * Pangram
 */

object Pangram {

    fun isPangram_1(input: String) = input
            .asSequence()
            .map { it.toLowerCase() }
            .filter { it in 'a'..'z' }
            .distinct()
            .count() == 26

    fun isPangram_2(input: String): Boolean {
        val seen = HashSet<Char>()
        for (ch in input.toLowerCase()) {
            if (ch in 'a'..'z') {
                seen.add(ch)
            }
        }

        return seen.size == 26
    }
}


