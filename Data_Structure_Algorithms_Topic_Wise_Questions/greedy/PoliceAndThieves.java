package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

import java.util.ArrayList;
import java.util.List;

public class PoliceAndThieves {

    /*
        Approach:
            - The question is to catch thieves within a maximum distance of K.
            - We can use a **greedy + two-pointer approach** to solve this efficiently.

            Steps:
                1. Traverse the array and store the indices of all policemen and thieves in two separate lists.
                2. Use two pointers `i` and `j` to iterate over the police and thief index lists respectively.
                3. At each step:
                    - If the distance between the current police and thief is ≤ K, we catch the thief,
                        increment the count, and move both pointers forward.
                    - If the police is **too far ahead** of the thief, the thief cannot be caught,
                        so move the `j` pointer (to next thief).
                    - Else, move the `i` pointer (to next policeman), since this police can't catch this thief.

            Time Complexity: O(n) — each element is processed once.
            Space Complexity: O(p + t) — storing positions of police and thieves.
     */

    public static int catchThieves(char[] arr, int k) {
        // code here
        if(arr.length == 0) {
            return 0;
        }

        List<Integer> policePositions = new ArrayList<>();
        List<Integer> thievesPositions = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 'P') {
                policePositions.add(i);
            }else {
                thievesPositions.add(i);
            }
        }

        int i = 0;
        int j = 0;

        int thievesCaught = 0;

        while(i < policePositions.size() && j < thievesPositions.size()) {
            if(Math.abs(policePositions.get(i) - thievesPositions.get(j)) <= k) {
                thievesCaught++;
                i++;
                j++;
            }else if(policePositions.get(i) > thievesPositions.get(j)) {
                j++;
            }else {
                i++;
            }
        }
        return thievesCaught;
    }

    public static void main(String[] args) {
        System.out.println(catchThieves(new char[]{'T', 'T', 'P', 'P', 'T', 'P'}, 2));
    }
}
