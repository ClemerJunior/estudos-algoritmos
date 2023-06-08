package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DnaStrandTest {

    @Test
    void makeComplementTest() {
        assertEquals("TAACG", DnaStrand.makeComplement("ATTGC"));
    }

}