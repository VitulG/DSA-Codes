package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

public class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();

        int i = 0;
        int j = 0;

        while(i < word1.length() && j < word2.length()) {
            ans.append(word1.charAt(i++));
            ans.append(word2.charAt(j++));
        }

        while(i < word1.length()) {
            ans.append(word1.charAt(i++));
        }

        while(j < word2.length()) {
            ans.append(word2.charAt(j++));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd", "pq"));
    }
}
