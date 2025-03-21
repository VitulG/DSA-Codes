package Leetcode_75.arrays_strings;

public class ReverseWordsInAString {

    public static String reverseWords(String str) {
        if(str.length() == 1) {
            return str;
        }

        String[] words = str.trim().split("\\s+");

        int le = 0;
        int ri = words.length-1;

        while(le < ri) {
            String word = words[le];
            words[le] = words[ri];
            words[ri] = word;
            le++;
            ri--;
        }

        StringBuilder ans = new StringBuilder();

        for(String word : words) {
            ans.append(word).append(" ");
        }

        return ans.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
