package Data_Structure_Algorithms_Topic_Wise_Questions.bit_manipulation;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    // Approach 1. using set data structure
    public static int missingNumUsingSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int max = arr[0];

        for(int num : arr) {
            set.add(num);
            max = Math.max(max, num);
        }

        for(int i=1; i<=max; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static int missingNumUsingFormula(int[] arr) {
        long len = arr.length+1;
        long sum = 0;

        for(int num : arr) {
            sum += num;
        }

        long result = ((len * (len+1)) / 2) - sum;

        return (int) result;
    }

    public static int missingNumberUsingXor(int[] arr) {
        int elementsXor = 0;

        for(int num : arr) {
            elementsXor ^= num;
        }

        int totalElementXor = 0;

        for(int i=1; i<=arr.length+1; i++) {
            totalElementXor ^= i;
        }
        return elementsXor ^ totalElementXor;
    }

    public static void main(String[] args) {
        System.out.println(missingNumUsingSet(new int[]{8, 2, 4, 5, 3, 7, 1}));
        System.out.println(missingNumUsingFormula(new int[]{1, 2, 3, 4}));
        System.out.println(missingNumberUsingXor(new int[]{1,8,5,2,4,6,3}));
    }
}
