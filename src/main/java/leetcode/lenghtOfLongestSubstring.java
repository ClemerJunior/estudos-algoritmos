package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lenghtOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("abcbcbba"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("aab"));
        System.out.println(lengthOfLongestSubstring2("dvdf"));
        System.out.println(lengthOfLongestSubstring2("anviaj"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));


    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        char[] chars = s.toCharArray();
        int aux = 0;
        int result = 0;
        int counter = 0;
        int lastIndexWithRepeatingChar = 0;
        Map<Character, Integer> map = new HashMap<>();

        do {
            if(map.containsKey(chars[counter])) {
                int diff = map.get(chars[counter]) + lastIndexWithRepeatingChar;
                aux = counter - (diff);
                map.put(chars[counter], counter);
                lastIndexWithRepeatingChar = counter;
                aux += diff == 1 ? 1 : 0;
            } else {
                map.put(chars[counter], counter);
                aux++;
            }
            counter++;
            result = Math.max(result, aux);
        } while(counter < chars.length);
        return result;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty()) return 0;
        int result = 0;
        int counter = 0;
        Set<Character> set = new HashSet<>();

            while (counter < s.length()) {
                if(set.add(s.charAt(counter))) {
                    counter++;
                } else {
                    result = Math.max(result,set.size());
                    set.clear();
                }
            }
            result = Math.max(result, set.size());
            set.clear();
        return result;
    }
}



//Given a string s, find the length of the longest substring without repeating characters.
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

