package leetcode;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("bbbbb"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("nmxyncuzlwhiobggiowtjexyzbzyhuqmpnyyimazcrnhrnkydxnioqhtchnnoqhuezypyxiepdvyesihlvbuzctptsaowfllxfdqvbwyitsegpbarqqpcrrvemwkglouhhtuxjdeppatdiiwhwvrqxqjcmzhuwurlqrshlsjyxksfjmhykyhcbpmrbsmbrrjwndjsgqdrafidmelnobhtpblozbzttpzheeffwysfrrwtewjnmqoyrvfxmgcmdoadagatwyocixggwppnmtrnfrbiijwojpetuqwknvtqgspuogrbqqptsrljjiaalmqlchlszflyixxpnkttzbrvhzrjzfbpuquuyzwhattxvoqpzieguwvmlrggrlmvwugeizpqovxttahwzyuuqupbfzjrzhvrbzttknpxxiylfzslhclqmlaaijjlrstpqqbrgoupsgqtvnkwqutepjowjiibrfnrtmnppwggxicoywtagadaodmcgmxfvryoqmnjwetwrrfsywffeehzpttzbzolbpthbonlemdifardqgsjdnwjrrbmsbrmpbchykyhmjfskxyjslhsrqlruwuhzmcjqxqrvwhwiidtappedjxuthhuolgkwmevrrcpqqrabpgestiywbvqdfxllfwoastptczubvlhiseyvdpeixypyzeuhqonnhcthqoinxdyknrhnrczamiyynpmquhyzbzyxejtwoiggboihwlzucnyxmn"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (isPalindrome(substring) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }
        return longest;

    }

    //I need the implementatio of isPalindrome method
    private static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

//Given a string s, return the longest
//palindromic
//
//        substring
//in s.
//
//
//
//Example 1:
//
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
//        Example 2:
//
//Input: s = "cbbd"
//Output: "bb"
