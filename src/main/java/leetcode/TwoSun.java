package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSun {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum2(nums, target)));
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

    public static int[] twoSum2(int[] nums, int target) {

        HashMap<Integer, Integer> numMap = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            if(numMap.containsKey(target - nums[i])) {
                return new int[]{numMap.get(target - nums[i]), i};
            } else {
                numMap.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}
