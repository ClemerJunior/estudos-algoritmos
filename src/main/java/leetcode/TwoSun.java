package leetcode;

import java.util.Arrays;

public class TwoSun {

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {

        int i = 0;
        int sum = 0;
        int[] result = new int[2];
        do {
            for(int j = i+1; j < nums.length; j++ ) {
                sum = nums[i] + nums[j];
                if(sum == target) {
                    result[0] = i;
                    result[1] = j;

                    break;
                }
            }
            i++;
        } while(sum != target);

        return result;
    }
}
