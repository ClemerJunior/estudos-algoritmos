package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KataTest {

    @Test
    void highAndLowTest() {
        var kata = new Kata();
        assertEquals("42 -9", kata.highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    @Test
    void highAndLowSimplerTest() {
        var kata = new Kata();
        assertEquals("42 -9", kata.highAndLowSimpler("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

}