public class CheckIfOneStringSwapCanMakeStringsEqual {

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;  // Already equal, no swap needed

        int n = s1.length();
        int first = -1, second = -1; // To store indices of mismatched characters
        int mismatchCount = 0;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                mismatchCount++;
                if (mismatchCount > 2) return false; // More than 2 mismatches, not possible

                if (first == -1) {
                    first = i; // Store first mismatch index
                } else {
                    second = i; // Store second mismatch index
                }
            }
        }

        // If exactly 2 mismatches exist, check if swapping them fixes the issue
        return (mismatchCount == 2) &&
                (s1.charAt(first) == s2.charAt(second)) &&
                (s1.charAt(second) == s2.charAt(first));
    }

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
    }
}
