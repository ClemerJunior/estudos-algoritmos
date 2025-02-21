package leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        String s = "Hello        World  asdf";
        String s1 = "Hello World";
        String s2 = " Hello World ";
        String s3 = "Hello";
        String s4 = " Hello ";
        String s5 = "He";
        String s6 = "H  O";
        String s7 = "";
        String s8 = "      ";
        String s9 = null;
        String s10 = "H      OI";


        System.out.println("s: " + reverseWords9(s));
        System.out.println("s1: " + reverseWords9(s1));
        System.out.println("s2: " + reverseWords9(s2));
        System.out.println("s3: " + reverseWords9(s3));
        System.out.println("s4: " + reverseWords9(s4));
        System.out.println("s5: " + reverseWords9(s5));
        System.out.println("s6: " + reverseWords9(s6));
        System.out.println("s7: " + reverseWords9(s7));
        System.out.println("s8: " + reverseWords9(s8));
        System.out.println("s9: " + reverseWords9(s9));
        System.out.println("s9: " + reverseWords9(s10));
    }

    public static String reverseWords(String s) {
        if(s == null || s.isBlank()) return "";

        StringBuilder result = new StringBuilder();
        int begin = 0;
        List<String> words = List.of(s.split(" "));

        for(String word : words) {
            if(word.isBlank()) continue;

            int end = word.length()-1;
            while(end >= begin) {
                result.append(word.charAt(end));
                end--;
            }
            result.append(" ");
        }

        return result.toString();
    }

    public static String reverseString(String s) {
        if(s == null || s.isBlank()) return "";

        return String.join(" ", List.of(s.trim().split("\\s+")).reversed());
    }

    public static String reverseWords2(String s) {
        if(s == null || s.isBlank()) return "";
        if(s.length() == 1) return s;

        StringBuilder result = new StringBuilder();

        List<String> words = List.of(s.split(" "));
        for(int i = words.size()-1; i >= 0; i--) {
            String word = words.get(i);
            if(word.isBlank()) continue;

            result.append(word);
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static String reverseWords3(String s) {
        if(s == null || s.isBlank()) return "";

        StringBuilder result = new StringBuilder();

        List<String> words = Stream.of(s.split(" ")).filter(w -> !w.isBlank())
                .toList()
                .reversed();

        for(String word : words) {
            result.append(word);
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static String reverseWords4(String s) {
        if(s == null) return "";

        return Stream.of(s.split(" "))
                .filter(w -> !w.isBlank())
                .toList()
                .stream()
                .map(w -> {
                    StringBuilder result = new StringBuilder();
                    char lastChar = w.charAt(w.length()-1);
                    for(int i = w.length()-1; i >= 0; i--) {
                        char current = w.charAt(i);
                        if(current != ' ' || lastChar != ' ') {
                            result.append(current);
                        }
                        lastChar = w.charAt(i);
                    }
                    return result.toString().trim();
                })
                .reduce("", (w1,w2) -> w1.concat(" ")
                        .concat(w2)).trim();
    }

    public static String reverseWords5(String s) {
        StringBuilder result = new StringBuilder();
        char lastChar = s.charAt(s.length()-1);
        for(int i = s.length()-1; i >= 0; i--) {
            char current = s.charAt(i);
            if(current != ' ' || lastChar != ' ') {
                result.append(current);
            }
            lastChar = s.charAt(i);
        }
        return result.toString().trim();
    }

    public static String reverseWords6(String s) {
        if(s == null || s.isBlank()) return "";

        StringBuilder result = new StringBuilder();

        List<String> words = List.of(s.split(" "));

        for(String word : words) {
            if(word.isBlank()) continue;


            int begin = 0;
            int end = word.length()-1;
            char[] chars = word.toCharArray();

            while(end > begin) {
                char lastChar = chars[end];
                chars[end] = chars[begin];
                chars[begin] = lastChar;
                begin++;
                end--;
            }

            result.append(chars);
            result.append(" ");
        }

        return result.toString().trim();
    }


    public static String reverseWords7(String s) {
        if(s == null || s.isBlank()) return "";

        StringBuilder result = new StringBuilder();

            int begin = 0;
            int end = s.indexOf(" ");

            if(end == -1) end = s.length();

            do {
                char[] chars = s.substring(begin, end).toCharArray();
                begin = 0;

                int temp = chars.length == 0 ? 0 : chars.length -1;
                while(begin < temp) {
                    char lastChar = chars[temp];
                    chars[temp] = chars[begin];
                    chars[begin] = lastChar;
                    begin++;
                    temp--;
                }

                begin = s.indexOf(" ", end) + 1;
                end =  s.indexOf(" ", begin) == -1 ? s.length() : s.indexOf(" ", begin);

                if(chars.length > 0) {
                    result.append(chars);
                    if(begin > 0 && begin != end) result.append(" ");
                }
            } while(begin > 0);

        return result.toString();
    }

    public static String reverseWords8(String s) {
        if(s == null || s.isBlank()) return "";

        StringBuilder result = new StringBuilder();

        int begin = 0;
        int end = s.indexOf(" ");

        if(end == -1) end = s.length();

        do{

            String word = s.substring(begin, end);

            begin = s.indexOf(" ", end) + 1;
            end =  s.indexOf(" ", begin) == -1 ? s.length() : s.indexOf(" ", begin);

            if(!word.isEmpty()) {
                result.insert(0, word);
                if(begin > 0) result.insert(0," ");
            }
        } while(begin > 0);

        return result.toString().trim();
    }

    public static String reverseWords9(String s) {
        if(s == null || s.isBlank()) return "";

        StringBuilder result = new StringBuilder();
        String[] words = s.split("\\s+");

        for(int i = words.length-1; i >= 0; i--) {
            result.append(words[i]).append(" ");
        }

        return result.toString().trim();
    }
}
