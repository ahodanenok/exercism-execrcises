/**
 * https://exercism.io/my/tracks/kotlin
 * Resistor Color
 */

object ResistorColor_1 {

    private val codes = mapOf(
        "black" to 0,
        "brown" to 1,
        "red" to 2,
        "orange" to 3,
        "yellow" to 4,
        "green" to 5,
        "blue" to 6,
        "violet" to 7,
        "grey" to 8,
        "white" to 9
    )

    fun colorCode(input: String): Int {
        return codes[input.toLowerCase()] ?: throw IllegalArgumentException("Illegal color: $input")
    }

    fun colors(): List<String> {
        return codes.keys.toList()
    }
}

object ResistorColor_2 {

    private val codes = listOf(
        "black",
        "brown",
        "red",
        "orange",
        "yellow",
        "green",
        "blue",
        "violet",
        "grey",
        "white"
    )

    fun colorCode(input: String): Int {
        return codes.indexOf(input.toLowerCase()).takeIf { it != -1 }
                ?: throw IllegalArgumentException("Illegal color: $input")
    }

    fun colors(): List<String> {
        return codes
    }
}
