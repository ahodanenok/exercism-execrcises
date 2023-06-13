import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Protein Translation
 * https://exercism.org/tracks/java/exercises/protein-translation
 */
class ProteinTranslator {

    private static final int CODON_LENGTH = 3;
    private static final String CODON_STOP = "STOP";
    private static final Map<String, String> CODON_ACIDS = Map.ofEntries(
        Map.entry("AUG", "Methionine"),
        Map.entry("UUU", "Phenylalanine"),
        Map.entry("UUC", "Phenylalanine"),
        Map.entry("UUA", "Leucine"),
        Map.entry("UUG", "Leucine"),
        Map.entry("UCU", "Serine"),
        Map.entry("UCC", "Serine"),
        Map.entry("UCA", "Serine"),
        Map.entry("UCG", "Serine"),
        Map.entry("UAU", "Tyrosine"),
        Map.entry("UAC", "Tyrosine"),
        Map.entry("UGU", "Cysteine"),
        Map.entry("UGC", "Cysteine"),
        Map.entry("UGG", "Tryptophan"),
        Map.entry("UAA", CODON_STOP),
        Map.entry("UAG", CODON_STOP),
        Map.entry("UGA", CODON_STOP)
    );

    List<String> translate(String rnaSequence) {
        List<String> acids = new ArrayList<>();
        for (int i = 0; i < rnaSequence.length(); i+= CODON_LENGTH) {
            String codon = rnaSequence.substring(i, i + CODON_LENGTH);
            String acid = CODON_ACIDS.get(codon);
            if (acid == null) {
                throw new IllegalArgumentException("Unknown codon: " + codon);
            }

            if (acid == CODON_STOP) {
                break;
            }

            acids.add(acid);
        }

        return acids;
    }
}
