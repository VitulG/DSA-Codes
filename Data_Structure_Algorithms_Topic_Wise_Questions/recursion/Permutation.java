package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void generatePermutations(String str, int idx, StringBuilder curr, List<String> permutations,
                                            boolean[] isUsed) {
        if(idx >= str.length()) {
            permutations.add(curr.toString());
            return;
        }

        for(int i=0; i<str.length(); i++) {
            if(!isUsed[i]) {
                curr.append(str.charAt(i));
                isUsed[i] = true;
                generatePermutations(str, idx+1, curr, permutations, isUsed);
                curr.deleteCharAt(curr.length()-1);
                isUsed[i] = false;
            }
        }
    }

    public static List<String> generatePermute(String str) {
        if(str.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> permutations = new ArrayList<>();
        boolean[] isUsed = new boolean[str.length()];

        generatePermutations(str, 0, new StringBuilder(), permutations, isUsed);

        return permutations;
    }

    public static void main(String[] args) {
        System.out.println(generatePermute("ABC"));
    }
}
