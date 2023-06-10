package challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSortChallengeTest {
    private static final String STRING_1 = "Freedom";
    private static final String STRING_2 = "Freedomzz";

    private static final String STRING_3 = "Programmingmm";
    private static final String EXPECTEC_STRING_1 = "eedfmor";
    private static final String EXPECTEC_STRING_2 = "eezzdfmor";

    private static final String EXPECTEC_STRING_3 = "mmmmggrrainop";

    @Test
    void sortStringWithDuplicates() {
        var returnString = StringSortChallenge.sortStringWithDuplicates(STRING_1);
        assertEquals(EXPECTEC_STRING_1, returnString);

        returnString = StringSortChallenge.sortStringWithDuplicates(STRING_2);
        assertEquals(EXPECTEC_STRING_2, returnString);

        returnString = StringSortChallenge.sortStringWithDuplicates(STRING_3);
        assertEquals(EXPECTEC_STRING_3, returnString);
    }

    @Test
    void sortStringWithDuplicatesPrimitives() {
        var returnString = StringSortChallenge.sortStringWithDuplicatesPrimitives(STRING_1);
        assertEquals(EXPECTEC_STRING_1, returnString);

        returnString = StringSortChallenge.sortStringWithDuplicatesPrimitives(STRING_2);
        assertEquals(EXPECTEC_STRING_2, returnString);

        returnString = StringSortChallenge.sortStringWithDuplicatesPrimitives(STRING_3);
        assertEquals(EXPECTEC_STRING_3, returnString);
    }
}