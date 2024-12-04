public class MakeStringASubsequenceUsingCyclicIncrements {
    public static boolean canMakeSubsequence(String str1, String str2) {
        if(str1.length() < str2.length()) {
            return false;
        }

        int idx1 = 0;
        int idx2 = 0;

        while(idx1 < str1.length()) {
            if(idx2 < str2.length() && str1.charAt(idx1) == str2.charAt(idx2)) {
                idx1++;
                idx2++;
            }else if(idx2 < str2.length() && str1.charAt(idx1) != str2.charAt(idx2)){
                char nextChar = (str1.charAt(idx1) == 'z') ? 'a' : (char) (str1.charAt(idx1) + 1);
                if(nextChar == str2.charAt(idx2)) {
                    idx2++;
                }
                idx1++;
            }
        }
        return idx2 >= str2.length();

    }

    public static void main(String[] args) {
        System.out.println(canMakeSubsequence("ab","d"));
    }
}
