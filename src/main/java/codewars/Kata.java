package codewars;

import java.util.Arrays;

public class Kata {

    private Kata() {
    }

    /**
     * This is my first solution without looking at any other solutions or answers.
     * O(n)
     *
     * @param numbers
     * @return A String containing the highest and lowest numbers in the input string separated by a space.
     */
    public static String highAndLow(String numbers) {
        var builder = new StringBuilder();

        int[] numbersArray = Arrays.stream(numbers.split("\\s+"))
                .mapToInt(Integer::valueOf).sorted().toArray();

        builder.append(numbersArray[numbersArray.length -1])
                .append(" ")
                .append(numbersArray[0]);

        return builder.toString();
    }

    /**
     * This is a solution given by another user on the code Wars site that I liked a lot and put it here
     * for the sake of knowledge.
     * O(n)
     *
     * @param numbers
     * @return String containing the highest and lowest numbers in the input string separated by a space
     */
    public static String highAndLowSimpler(String numbers) {
        var stats = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
        return stats.getMax() + " " + stats.getMin();
    }
}
