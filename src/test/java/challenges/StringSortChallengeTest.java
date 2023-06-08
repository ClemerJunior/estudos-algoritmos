package challenges;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSortChallengeTest {


    private static StringSortChallenge stringSortChallenge;

    private static final String STRING_1 = "Freedom";
    private static final String STRING_2 = "Freedomzz";

    private static final String STRING_3 = "Programmingmm";
    private static final String EXPECTEC_STRING_1 = "eedfmor";
    private static final String EXPECTEC_STRING_2 = "eezzdfmor";

    private static final String EXPECTEC_STRING_3 = "mmmmggrrainop";


    @BeforeAll
    static void setub() {
        stringSortChallenge = new StringSortChallenge();
    }

    @Test
    void sortStringWithDuplicates() {
        var returnString = stringSortChallenge.sortStringWithDuplicates(STRING_1);
        assertEquals(EXPECTEC_STRING_1, returnString);

        returnString = stringSortChallenge.sortStringWithDuplicates(STRING_2);
        assertEquals(EXPECTEC_STRING_2, returnString);

        returnString = stringSortChallenge.sortStringWithDuplicates(STRING_3);
        assertEquals(EXPECTEC_STRING_3, returnString);
    }

    @Test
    void sortStringWithDuplicatesPrimitives() {
        var returnString = stringSortChallenge.sortStringWithDuplicatesPrimitives(STRING_1);
        assertEquals(EXPECTEC_STRING_1, returnString);

        returnString = stringSortChallenge.sortStringWithDuplicatesPrimitives(STRING_2);
        assertEquals(EXPECTEC_STRING_2, returnString);

        returnString = stringSortChallenge.sortStringWithDuplicatesPrimitives(STRING_3);
        assertEquals(EXPECTEC_STRING_3, returnString);
    }
}