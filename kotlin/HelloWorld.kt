/**
 * https://exercism.io/my/tracks/kotlin
 * Hello World
 */

fun hello_1(): String {
    return "Hello, World!"
}

fun hello_2() = "Hello, World!"

fun hello_3(): String {
    val h = "Hello"
    val w = "World"
    return "$h, $w!"
}

fun hello_4(): String {
    val sb = StringBuilder()
    listOf("Hello", "World").joinTo(sb, separator = ", ", prefix = "", postfix = "!")
    return sb.toString()
}

val hello_5 = { "Hello, World!" }

fun hello_6(): String {
    return listOf("Hello", ", ", "World", "!").reduce { acc, s -> acc + s }
}
