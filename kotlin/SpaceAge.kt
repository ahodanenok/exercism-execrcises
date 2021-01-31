/**
 * https://exercism.io/my/tracks/kotlin
 * Space Age
 */

import kotlin.math.roundToInt

class SpaceAge(private val seconds: Long) {

    fun onEarth(): Double = round(earthAge())
    fun onMercury(): Double = round(earthAge() / 0.2408467)
    fun onVenus(): Double = round(earthAge() / 0.61519726)
    fun onMars(): Double = round(earthAge() / 1.8808158)
    fun onJupiter(): Double = round(earthAge() / 11.862615)
    fun onSaturn(): Double = round(earthAge() / 29.447498)
    fun onUranus(): Double = round(earthAge() / 84.016846)
    fun onNeptune(): Double = round(earthAge() / 164.79132)

    private fun earthAge(): Double = seconds / 31557600.0

    private fun round(age: Double): Double {
        return age.times(100).roundToInt().div(100.0)
    }
}
