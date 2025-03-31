package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class PowerSet {

    public static void generatePowerSet(String str, int idx, StringBuilder curr, ArrayList<String> sets) {
        if(idx >= str.length()) {
            sets.add(curr.toString());
            return;
        }

        generatePowerSet(str, idx+1, curr, sets);

        curr.append(str.charAt(idx));
        generatePowerSet(str, idx+1, curr, sets);
        curr.deleteCharAt(curr.length()-1);
    }

    public static ArrayList<String> powerSet(String str) {
        if(str.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<String> sets = new ArrayList<>();
        generatePowerSet(str, 0, new StringBuilder(), sets);

        Collections.sort(sets);
        return sets;
    }

    public static void main(String[] args) {
        System.out.println(powerSet("abc"));
    }
}
