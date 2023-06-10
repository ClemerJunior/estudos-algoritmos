package codewars;

import java.util.stream.IntStream;

public class GrassHopper {

    private GrassHopper(){}

    /**
     * Method to calculate the sum of every number from 1 to the given number "n".
     * Solution using only mathematical operation. Elegant, efficient and simple.
     * O(1)
     *
     * @param n any given number where n > 0
     * @return the sum of numbers from 1 to n
     */
    public static int summation(int n) {
        return n > 0 ? n*(n+1)/2 : 0;
    }

    /**
     * Method to calculate the sum of every number from 1 to the given number "n".
     * Solution using a for loop to sum.
     * O(n)
     *
     * @param n any given number where n > 0
     * @return the sum of numbers from 1 to n
     */
    public static int summationWithLoop(int n) {
        var sum = 0;
        for(int i = 1; i <= n; i++) {
            sum+= i;
        }
        return sum;
    }

    /**
     * Method to calculate the sum of every number from 1 to the given number "n".
     * Solution creating a list of ints to use stream api and method reduce to sum, not the best solution.
     * O(n)
     *
     * @param n any given number where n >= 1
     * @return the sum of numbers from 1 to n
     */
    public static int summationWithList(int n) {
        return IntStream.rangeClosed(1, n)
                .boxed()
                .toList()
                .stream()
                .reduce(0,(Integer::sum));
    }

    /**
     * Method to calculate the sum of every number from 1 to the given number "n".
     * Solution using IntStream to create a range from 1 to N and then invoking the
     * method sum from IntStream class to get the result. Simple.
     * O(n)
     *
     * @param n any given number where n > 0
     * @return the sum of numbers from 1 to n
     */
    public static int summationWithStream(int n) {
        return IntStream.rangeClosed(1, n).sum();
    }


}
