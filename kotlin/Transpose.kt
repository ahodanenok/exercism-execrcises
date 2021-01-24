/**
 * https://exercism.io/my/tracks/kotlin
 * Transpose
 */

object Transpose {

    fun transpose_1(input: List<String>): List<String> {
        val rows = input.maxBy { it.length }?.length ?: return emptyList()

        val result = mutableListOf<String>()
        for (row in 0 until rows) {
            val sb = StringBuilder()
            for ((idx, str) in input.withIndex()) {
                if (str.length <= row) {
                    continue
                }

                while (sb.length < idx) {
                    sb.append(' ')
                }

                sb.append(str[row])
            }

            result.add(sb.toString())
        }

        return result
    }

    fun transpose_2(input: List<String>): List<String> {
        val rows = input.maxBy { it.length }?.length ?: return emptyList()
        return (0 until rows).map { row ->
            input.withIndex()
                .filter { it.value.length > row }
                .fold(StringBuilder()) { sb, p ->
                    sb.append(" ".repeat(p.index - sb.length)).append(p.value[row])
                }
                .toString()
        }
    }
}
