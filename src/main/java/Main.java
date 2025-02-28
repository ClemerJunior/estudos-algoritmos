import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        //reverseNumber using String
        test(321, 123, reverseNumber);
        test(-321, -123, reverseNumber);
        test(31, 13,reverseNumber);
        test(-31, -13,reverseNumber);
        test(1, 1,reverseNumber);
        test(0, 1534236469,reverseNumber);
        test(0, -2147483648,reverseNumber);

        //reverseNumber using long and math
        test(321, 123, reverseNumber2);
        test(-321, -123, reverseNumber2);
        test(31, 13,reverseNumber2);
        test(-31, -13,reverseNumber2);
        test(1, 1,reverseNumber2);
        test(0, 1534236469,reverseNumber2);
        test(0, -2147483648,reverseNumber2);
    }

    static Function<Integer, Integer>  reverseNumber = (x) -> {
        String s = String.valueOf(x);

        boolean isNegative = s.charAt(0) == '-';
        int high = isNegative ? s.length() - 2 : s.length() - 1;
        int low = 0;
        char[] cs = isNegative ? s.substring(1).toCharArray() : s.toCharArray();

        while(high>low) {
            char aux = cs[low];
            cs[low] = cs[high];
            cs[high] = aux;

            low++;
            high--;
        }

        long test = Long.parseLong(String.copyValueOf(cs));

        if(test > 2147483647 || test < -2147483648) return 0;

        int res = Integer.parseInt(String.copyValueOf(cs));


        return isNegative ? res * -1: res;
    };

    static Function<Integer, Integer> reverseNumber2 = (x) ->{
        long reversed = 0;
        boolean isNegative = x < 0;
        x = Math.abs(x);

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }

        return isNegative ? (int) -reversed : (int) reversed;
    };

    public static void test(int expected, int value, Function<Integer, Integer> function) {
        long start = System.nanoTime();
        int actual = function.apply(value);
        long end = System.nanoTime();
        System.out.println("Expected: " + expected + " Actual: " + actual);
        System.out.println("Result: " + (expected == actual ? "Passed" : "Failed"));
        System.out.println("Time: " + (end - start) + " ns");
    }

    //BDDMOckito
}
