package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassHopperTest {

    @Test
    void summationTest() {
        assertEquals(0, GrassHopper.summation(-8));
        assertEquals(0, GrassHopper.summation(0));
        assertEquals(3, GrassHopper.summation(2));
        assertEquals(36, GrassHopper.summation(8));
    }

    @Test
    void summationWithLoopTest() {
        assertEquals(0, GrassHopper.summationWithLoop(-8));
        assertEquals(0, GrassHopper.summationWithLoop(0));
        assertEquals(3, GrassHopper.summationWithLoop(2));
        assertEquals(36, GrassHopper.summationWithLoop(8));
    }

    @Test
    void summationWithListTest() {
        assertEquals(0, GrassHopper.summationWithList(-8));
        assertEquals(0, GrassHopper.summationWithList(0));
        assertEquals(3, GrassHopper.summationWithList(2));
        assertEquals(36, GrassHopper.summationWithList(8));
    }

    @Test
    void summationWithStreamTest() {
        assertEquals(0, GrassHopper.summationWithStream(-8));
        assertEquals(0, GrassHopper.summationWithStream(0));
        assertEquals(3, GrassHopper.summationWithStream(2));
        assertEquals(36, GrassHopper.summationWithStream(8));
    }

}