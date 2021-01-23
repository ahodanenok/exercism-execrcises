/**
 * https://exercism.io/my/tracks/kotlin
 * Resistor Color Trio
 */

import kotlin.math.log10
import kotlin.math.pow

object ResistorColorTrio {

    fun text_1(vararg input: Color): String {
        if (input.size < 3) {
            throw IllegalArgumentException("Provide at least 3 colors")
        }

        val first = input[0]
        val second = input[1]
        val third = input[2]

        val base: Int
        val exp: Int
        if (second.code != 0) {
            base = first.code * 10 + second.code
            exp = third.code
        } else {
            base = first.code
            exp = third.code + 1
        }

        val unit = Unit.values().findLast { it.exp <= exp }
                ?: throw IllegalStateException("Unsupported ohms value with $exp zeroes")
        val multiplier = 10.0.pow(exp - unit.exp).toInt()

        return "${base * multiplier} ${unit.name.toLowerCase()}"
    }

    fun text_2(vararg input: Color): String {
        if (input.size < 3) {
            throw IllegalArgumentException("Provide at least 3 colors")
        }

        val first = input[0]
        val second = input[1]
        val third = input[2]

        // find total value and count number of zeroes
        val ohms = (first.code * 10 + second.code) * 10.0.pow(third.code)
        val exp = log10(ohms)

        val unit = Unit.values().findLast { it.exp <= exp }
                ?: throw IllegalStateException("Unsupported ohms value with $exp zeroes")
        val base = ohms / 10.0.pow(unit.exp)

        return "${base.toInt()} ${unit.name.toLowerCase()}"
    }

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
        WHITE(9)
    }

    enum class Unit(val exp: Int) {
        OHMS(0),
        KILOOHMS(3),
        MEGAOHMS(6),
        GIGAOHMS(9),
        TERAOHMS(12),
        PETAOHMS(15),
        EXAOHMS(18)
    }
}
