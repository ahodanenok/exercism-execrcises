/**
 * https://exercism.io/my/tracks/kotlin
 * Two Fer
 */

fun twofer_1(name: String = "you"): String {
    return "One for $name, one for me."
}

fun twofer_2(name: String = "you") = "One for $name, one for me."

fun twofer_3(name: String = "you"): String {
    return listOf("One for $name", "one for me").joinToString(separator = ", ", postfix = ".")
}
