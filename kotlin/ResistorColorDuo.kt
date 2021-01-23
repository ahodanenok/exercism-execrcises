/**
 * https://exercism.io/my/tracks/kotlin
 * Resistor Color Duo
 */

enum class Color(val code: Int) {
    BLACK(0),
    BROWN(1),
    RED(2),
    ORANGE(3),
    YELLOW(4),
    GREEN(5),
    BLUE(6),
    VIOLET(7),
    GREY(8),
    WHITE(9);
}

object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        if (colors.size < 2) {
            throw IllegalArgumentException("Provide at least 2 colors")
        }

        return colors[0].code * 10 + colors[1].code
    }
}
