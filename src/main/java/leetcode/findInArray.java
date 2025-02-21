package leetcode;

public class findInArray {

    public static void main(String[] args) {
        System.out.println(dechiper("aapple orange sun ice echo"));
    }

    public static String dechiper(String text) {

        text = text.replaceAll("(?<![AEIOUaeiou])[Aa](?![AEIOUaeiou])", "ava");
        text = text.replaceAll("(?<![AEIOUaeiou])[Ee](?![AEIOUaeiou])", "ave");
        text = text.replaceAll("(?<![AEIOUaeiou])[Ii](?![AEIOUaeiou])", "avi");
        text = text.replaceAll("(?<![AEIOUaeiou])[Oo](?![AEIOUaeiou])", "avo");
        text = text.replaceAll("(?<![AEIOUaeiou])[Uu](?![AEIOUaeiou])", "avu");
        return text;
    }
}
