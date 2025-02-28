package leetcode;

import java.util.Set;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate2(new int[] {1,2,3,4,5,6,7,8,9,9}, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0) {
            return false;
        }

        int left = 0;

        while(left < nums.length) {
            int right = left + 1;
            while (Math.abs(left - right) <= k && right < nums.length) {
                if(nums[left] == nums[right]) {
                    return true;
                }
                right++;
            }
            left++;
        }

        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return false;
        }

        Set<Integer> set = new java.util.HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
