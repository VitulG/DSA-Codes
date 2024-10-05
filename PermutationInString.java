import java.util.Arrays;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 > len2) {
            return false;
        }

        int[] countS1 = new int[26];

        for(char ch : s1.toCharArray()) {
            countS1[ch - 'a']++;
        }

        int i =0;
        int j =0;

        int[] countS2 = new int[26];

        while(j < len2) {
            char currChar = s2.charAt(j);
            countS2[currChar - 'a']++;

            // shrink the array
            if(j - i + 1 > len1) {
                countS2[s2.charAt(i)-'a']--;
                i++;
            }

            if(Arrays.equals(countS1, countS2)) {
                return true;
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
