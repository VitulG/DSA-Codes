package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class IsSubsequence {

    public static boolean isSubsequences(String s, String t) {
        if(s.isEmpty()) {
            return true;
        }

        if(t.isEmpty()) {
            return false;
        }

        int sp = 0;
        int tp = 0;

        while(tp < t.length()) {
            if(s.charAt(sp) == t.charAt(tp)) {
                sp++;

                if(sp == s.length()) {
                    return true;
                }
            }
            tp++;
        }
        return sp == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequences("b", "abc"));
    }
}
