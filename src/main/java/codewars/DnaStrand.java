package codewars;

import java.util.Arrays;

public class DnaStrand {

    private DnaStrand() {
    }

    /** A method to make the DNA complement of an input string representing a DNA sequence.
     * o(n)
     *
     * @param dna string representing a DNA sequence
     * @return a string representing the counterpart of the DNA sequence input.
     */
    public static String makeComplement(String dna) {
        return Arrays.stream(dna.split(""))
                .map(l -> switch (l) {
                    case "A" -> "T";
                    case "T" -> "A";
                    case "G" -> "C";
                    case "C" -> "G";
                    default -> "";
                }).reduce("", String::concat);
    }
}
