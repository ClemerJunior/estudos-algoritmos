package challenges;

import java.util.*;

public class StringSortChallenge {

    /**
     * This method takes a string and sort the letters in alphabetical order
     * but if there is repeated letters, those must come first also sorted.
     * The method uses Java Utils Libraries such as Collections.
     *
     * @param inputString
     * @return sortedString
     */
    public String sortStringWithDuplicates(String inputString) {
        char[] charArray = inputString.toLowerCase().toCharArray();
        Map<Character, Integer> charCount = new HashMap<>();
        List<Character> charList = new ArrayList<>();

        for (char c : charArray) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1); //count the char occurrences
            charList.add(c); // adds to List implementation to easy the manipulation using Java stream API
        }


        StringBuilder sortedString = new StringBuilder();
        charList.stream().sorted((c1, c2) -> {
            int countCompare = Integer.compare(charCount.get(c2), charCount.get(c1));
            if (countCompare == 0) {
                return Character.compare(c1, c2);
            } else {
                return countCompare;
            }
        }).forEach(sortedString::append);

        return sortedString.toString();
    }


    /**
     * This method takes a string and sort the letters in alphabetical order
     * but if there is repeated letters, those must come first also sorted.
     * The method does not use Java Utils Libraries such as Collections,
     * it's implemented using only primitive types and arrays.
     *
     * @param inputString
     * @return sortedString
     */
    public String sortStringWithDuplicatesPrimitives(String inputString) {
        char[] charArray = inputString.toLowerCase().toCharArray();
        int[] charCount = new int[128]; // Assuming ASCII characters

        for (char c : charArray) {
            charCount[c]++;
        }

        int n = charArray.length;
        char[] sortedArray = new char[n];
        int index = 0;

        // Sorting the characters based on count and ASCII value
        for (int count = n; count >= 1; count--) {
            for (int i = 0; i < 128; i++) {
                if (charCount[i] == count) {
                    char c = (char) i;
                    for (int j = 0; j < count; j++) {
                        sortedArray[index++] = c;
                    }
                }
            }
        }

        return new String(sortedArray);
    }
}
