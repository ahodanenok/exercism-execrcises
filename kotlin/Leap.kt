/**
 * https://exercism.io/my/tracks/kotlin
 * Leap
 */

data class Year(val year: Int) {

    val isLeap: Boolean
        get() = year.rem(4) == 0 && (year.rem(400) == 0 || year.rem(100) != 0)
}
