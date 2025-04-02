package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void generateCombinations(int num, int idx, int k, List<Integer> currList,
                                            List<List<Integer>> combinations) {
        if(currList.size() == k) {
            combinations.add(new ArrayList<>(currList));
            return;
        }

        for(int i=idx; i<=num; i++) {
            currList.add(i);
            generateCombinations(num, i+1, k, currList, combinations);
            currList.remove(currList.size()-1);
        }

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();

        generateCombinations(n, 1, k, new ArrayList<>(), combinations);

        return combinations;

    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}
