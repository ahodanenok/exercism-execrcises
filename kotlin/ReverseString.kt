/**
 * https://exercism.io/my/tracks/kotlin
 * Reverse String
 */

import java.util.LinkedList

fun reverse_1(input: String) = input.reversed()

fun reverse_2(input: String): String {
    val array = CharArray(input.length)
    for ((idx, ch) in input.withIndex()) {
        array[array.size - idx - 1] = ch
    }

    return String(array)
}

fun reverse_3(input: String): String {
    val stack = LinkedList<Char>()
    input.forEach { stack.push(it) }

    val sb = StringBuilder()
    while (!stack.isEmpty()) {
        sb.append(stack.pop())
    }

    return sb.toString()
}

fun reverse_4(input: String): String {
    val sb = StringBuilder()
    input.forEach { sb.insert(0, it) }
    return sb.toString()
}

fun reverse_5(input: String): String {
    fun f(iterator: Iterator<Char>): String {
        return if (iterator.hasNext()) iterator.next().let { f(iterator) + it } else ""
    }

    return f(input.iterator())
}