/**
 * https://exercism.io/my/tracks/kotlin
 * Run Length Encoding
 */

object RunLengthEncoding_1 {

    fun encode(input: String): String {
        return input.replace(Regex("([^0-9])\\1+")) {
            "${it.groupValues[0].length}${it.groupValues[1]}"
        }
    }

    fun decode(input: String): String {
        return input.replace(Regex("([0-9]+)([^0-9])")) {
            it.groupValues[2].repeat(it.groupValues[1].toInt())
        }
    }
}

object RunLengthEncoding_2 {

    fun encode(input: String): String {
        return sequenceOf('\u0000')
                .plus(input.asSequence())
                .zipWithNext()
                .fold(mutableListOf<MutableList<Char>>()) { acc, pair ->
                    if (acc.isEmpty() || pair.first != pair.second) {
                        acc.add(mutableListOf())
                    }

                    acc.also { it.last().add(pair.second) }
                }
                .joinToString(separator = "") {
                    "${it.size.takeIf { s -> s > 1 } ?: ""}${it.first()}"
                }
    }

    fun decode(input: String): String {
        return sequenceOf('\u0000')
                .plus(input.asSequence())
                .zipWithNext()
                .fold(mutableListOf<StringBuilder>()) { acc, pair ->
                    if (acc.isEmpty() || !pair.first.isDigit()) {
                        acc.add(StringBuilder())
                    }

                    acc.also { it.last().append(pair.second) }
                }
                .joinToString(separator = "") {
                    it.last().toString().repeat(
                        it.dropLast(1).takeIf { s -> s.isNotEmpty() }?.toString()?.toInt() ?: 1)
                }
    }
}


object RunLengthEncoding_3 {

    fun encode(input: String): String {
        if (input.isEmpty()) {
            return ""
        }

        val sb = StringBuilder()
        var prev = input[0]
        var count = 1
        for (i in 1 until input.length) {
            val ch = input[i]
            if (ch != prev) {
                if (count > 1) sb.append(count)
                sb.append(prev)

                prev = ch
                count = 0
            }

            count++
        }

        if (count > 1) sb.append(count)
        sb.append(prev)

        return sb.toString()
    }

    fun decode(input: String): String {
        if (input.isEmpty()) {
            return ""
        }

        val sb = StringBuilder()
        val n = StringBuilder()
        for (i in input.indices) {
            val ch = input[i]
            if (ch.isDigit()) {
                n.append(ch)
                continue
            }

            if (n.isNotEmpty()) {
                sb.append(ch.toString().repeat(n.toString().toInt()))
                n.clear()
            } else {
                sb.append(ch)
            }
        }

        return sb.toString()
    }
}
