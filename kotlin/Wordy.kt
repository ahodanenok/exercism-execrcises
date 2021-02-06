/**
 * https://exercism.io/my/tracks/kotlin
 * Wordy
 */

import kotlin.math.pow

object Wordy_1 {

    private val globalPattern = Regex("^What is (-?\\d+)(.*)\\?$")
    private val exprPattern = Regex("^ ([^0-9]+) (-?\\d+)(.*)")
    private val powerPattern = Regex(" raised to the (\\d+)(st|nd|rd|th) power")

    fun answer(input: String): Int {
        val match = globalPattern.find(input) ?: throw IllegalArgumentException(input)
        return parseNext(match.groupValues[2], match.groupValues[1].toInt())
    }

    private fun parseNext(input: String, result: Int): Int {
        if (input.isEmpty()) {
            return result
        }

        val powerMatch = powerPattern.find(input)
        if (powerMatch != null) {
            return result.toDouble().pow(powerMatch.groupValues[1].toInt()).toInt()
        }

        val match = exprPattern.find(input) ?: throw IllegalStateException(input)
        val n = match.groupValues[2].toInt()
        return when (match.groupValues[1]) {
            "plus" -> parseNext(match.groupValues[3], result + n)
            "minus" -> parseNext(match.groupValues[3], result - n)
            "multiplied by" -> parseNext(match.groupValues[3], result * n)
            "divided by" -> parseNext(match.groupValues[3], result / n)
            else -> throw IllegalStateException(match.groupValues[1])
        }
    }
}

object Wordy_2 {

    fun answer(input: String): Int {
        val state = State(
            input.trim().takeIf { it.last() == '?' }?.dropLast(1)
                    ?: throw IllegalArgumentException("Question mark!"))
        match(state, "What")
        match(state, "is")
        return expr(state, number(state))
    }

    private fun expr(state: State, result: Int): Int {
        if (!state.hasNext()) {
            return result
        }

        return when (state.peek()) {
            "plus" -> {
                match(state, "plus")
                expr(state, result + number(state))
            }
            "minus" -> {
                match(state, "minus")
                expr(state, result - number(state))
            }
            "multiplied" -> {
                match(state, "multiplied")
                match(state, "by")
                expr(state, result * number(state))
            }
            "divided" -> {
                match(state, "divided")
                match(state, "by")
                expr(state, result / number(state))
            }
            "raised" -> {
                match(state, "raised")
                match(state, "to")
                match(state, "the")

                val p = state.next()
                val suffix = p.takeLast(2)
                if (suffix != "st" && suffix != "nd" && suffix != "rd" && suffix != "th") {
                    throw IllegalStateException(p)
                }

                match(state, "power")
                expr(state, result.toDouble().pow(p.dropLast(2).toInt()).toInt())
            }
            else -> throw IllegalStateException(state.peek())
        }
    }

    private fun match(state: State, s: String) {
        state.next() == s || throw IllegalStateException(s)
    }

    private fun number(state: State): Int {
        return state.next().toInt()
    }

    private class State(input: String) {

        private var pos = 0
        private val parts: List<String> = input.split(Regex("\\s+"))

        fun peek(): String = parts[pos]

        fun next(): String = parts[pos++]

        fun hasNext(): Boolean = pos < parts.size
    }
}
