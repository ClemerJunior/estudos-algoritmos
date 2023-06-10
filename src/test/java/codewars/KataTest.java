package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KataTest {

    @Test
    void highAndLowTest() {
        assertEquals("42 -9", Kata.highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    @Test
    void highAndLowSimplerTest() {
        assertEquals("42 -9", Kata.highAndLowSimpler("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

}