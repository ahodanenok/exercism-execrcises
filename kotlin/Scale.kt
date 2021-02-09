/**
 * https://exercism.io/my/tracks/kotlin
 * Scale Generator
 */

class Scale(tonic: String) {

    companion object {
        private val notes = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
        private val aliases = mapOf("Db" to "C#", "Eb" to "D#", "Gb" to "F#", "Ab" to "G#", "Bb" to "A#")
    }

    private val scale: List<String>

    init {
        val firstNoteIdx = when (tonic.length) {
            1 -> tonic.toUpperCase()
            else -> tonic.first().toUpperCase() + tonic.substring(1)
        }.let {
            notes.indexOf(aliases.getOrDefault(it, it))
        }

        scale = notes.subList(firstNoteIdx, notes.size) + notes.subList(0, firstNoteIdx)
    }

    fun chromatic(): List<String> = scale

    fun interval(intervals: String): List<String> {
        val intervalScale = mutableListOf<String>()

        var idx = 0
        for (i in intervals) {
            intervalScale.add(scale[idx])
            idx +=  when (i) {
                'm' -> 1
                'M' -> 2
                'A' -> 3
                else -> throw IllegalStateException("Unsupported interval: $i")
            }
        }

        return intervalScale
    }
}
