package codewars;

import java.util.Arrays;

public class DnaStrand {

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
