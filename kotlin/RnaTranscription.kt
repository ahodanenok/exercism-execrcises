/**
 * https://exercism.io/my/tracks/kotlin
 * RNA Transcription
 */

fun transcribeToRna_1(dna: String): String = Regex("[GCTA]").replace(dna) {
    when (it.value) {
        "G" -> "C"
        "C" -> "G"
        "T" -> "A"
        "A" -> "U"
        else -> throw IllegalStateException(it.value)
    }
}



val complements = mapOf(
    'G' to 'C',
    'C' to 'G',
    'T' to 'A',
    'A' to 'U'
)

fun transcribeToRna_2(dna: String): String =
        dna.map { complements[it] ?: throw IllegalStateException(it.toString()) }.joinToString(separator = "")

fun transcribeToRna_3(dna: String): String =
        dna.fold(StringBuilder()) { sb, ch ->
            sb.append(complements[ch] ?: throw IllegalStateException(ch.toString()))
        }.toString()



enum class DnaNucleotide(val complement: String) {

    G("C"),
    C("G"),
    T("A"),
    A("U")
}
fun transcribeToRna_4(dna: String): String {
    val sb = StringBuilder()
    for (ch in dna) {
        sb.append(DnaNucleotide.valueOf(ch.toString()).complement)
    }

    return sb.toString()
}
