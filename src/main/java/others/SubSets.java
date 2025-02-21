package others;

import javax.management.Query;
import javax.print.attribute.standard.QueuedJobCount;
import java.util.*;

public class SubSets {

    public static void main(String[] args) {
        int[] set = {1,2,3};
        List<List<Integer>> subsets = generateSubsets(set);
        System.out.println("subsets: " + subsets);
        Queue<Integer> queue = new PriorityQueue<>();
    }

    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < ( 1<< n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}
