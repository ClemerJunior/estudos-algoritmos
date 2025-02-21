package leetcode;

public class ZigZagConverstion {

    public static void main(String[] args) {
//        System.out.println(zigZag("PAYPALISHIRING", 7));
        System.out.println(zigZag("PAYPALISHIRINGRAMBOMAGILA", 7));
    }

    public static String zigZag(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder res  = new StringBuilder();
        int control = numRows * 2 - 2;
        int variation = control;
        int high = control;
        int low = 0;

        for(int i = 0; i < numRows; i++) {
            int index = i;


            while(index <= s.length() -1) {
                res.append(s.charAt(index));

                    if (variation != control && index != i) {
                        if(variation == high ) {
                            variation = low;
                        } else {
                            variation = high;
                        }
                    }

                index += variation;
            }

                high -= 2;
                low += 2;
            variation = high == 0 ? low : high;
        }
        return res.toString();
    }
}
