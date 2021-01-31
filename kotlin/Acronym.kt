/**
 * https://exercism.io/my/tracks/kotlin
 * Acronym
 */

object Acronym {
    fun generate(phrase: String) : String {
        return phrase
                .split(Regex("(\\s|-)+"))
                .joinToString(separator = "") {
                    it.first(Char::isLetter).toUpperCase().toString()
                }
    }
}
