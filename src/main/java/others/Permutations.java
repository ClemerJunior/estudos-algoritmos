package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Permutations {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        List<List<Integer>> permutations = generatePermutations(list);
        System.out.println("Permutations: " + permutations);
    }

    public static List<List<Integer>> generatePermutations(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(nums) || nums.isEmpty()) {
            return result;
        }


        if (nums.size() == 1) {
            result.add(new ArrayList<>(nums));
            return result;
        }

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> temp = new ArrayList<>(nums);
            temp.remove(i);
            List<List<Integer>> tempPermutations = generatePermutations(temp);

            for(List<Integer> permutation : tempPermutations) {
                permutation.add(0, nums.get(i));
                result.add(permutation);
            }
        }
        return result;
    }
}
