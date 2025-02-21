package others;

import java.util.*;

public class LetterCombination {

    private static final Map<Character, List<String>> PHONE_KEYBOARD = new HashMap<>(){};
    static {
        PHONE_KEYBOARD.put('2', Arrays.asList("a", "b", "c"));
        PHONE_KEYBOARD.put('3', Arrays.asList("d", "e", "f"));
        PHONE_KEYBOARD.put('4', Arrays.asList("g", "h", "i"));
        PHONE_KEYBOARD.put('5', Arrays.asList("j", "k", "l"));
        PHONE_KEYBOARD.put('6', Arrays.asList("m", "n", "o"));
        PHONE_KEYBOARD.put('7', Arrays.asList("p", "q", "r", "s"));
        PHONE_KEYBOARD.put('8', Arrays.asList("t", "u", "v"));
        PHONE_KEYBOARD.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(letterCombinations( "23"));
        System.out.println(letterCombinations( ""));
//        System.out.println(letterCombinations( "2"));
    }

    public static List<String> letterCombinations(String digits) {
        result.clear();
        if(digits.isEmpty()) return result;
        combineLetters("", digits);
        return result;
    }

        public static void combineLetters(String permutation, String digits) {
            if(digits.isEmpty()) {
                result.add(permutation);
                return;
            }
            List<String> letters = PHONE_KEYBOARD.get(digits.charAt(0));
            for (String letter : letters) {
                combineLetters(permutation + letter, digits.substring(1));
            }
        }
}

// {
//         "2": ["a", "b", "c"],
//         "3": ["d", "e", "f"],
//         "4": ["g", "h", "i"],
//         "5": ["j", "k", "l"],
//         "6": ["m", "n", "o"],
//         "7": ["p", "q", "r", "s"],
//         "8": ["t", "u", "v"],
//         "9": ["w", "x", "y", "z"]
//         }
