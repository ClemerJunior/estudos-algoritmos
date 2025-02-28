package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FirstUniqueChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {

        HashMap<Character, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.get(c).set(1, map.get(c).get(1) + 1);
            } else {
                map.put(c, Arrays.asList(i, 1));
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)).get(1) == 1) {
                return i;
            }
        }
        return -1;
    }
}
