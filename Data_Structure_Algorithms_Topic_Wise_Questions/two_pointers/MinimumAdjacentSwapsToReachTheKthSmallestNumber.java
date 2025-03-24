package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumAdjacentSwapsToReachTheKthSmallestNumber {

    public static void reverseArray(char[] chars, int st, int en) {
        while(st < en) {
            char temp = chars[st];
            chars[st] = chars[en];
            chars[en] = temp;
            st++;
            en--;
        }
    }

    public static int getMinimumSwaps(String num, char[] chars) {
        StringBuilder original = new StringBuilder(num);
        String kthPermutation = new String(chars);

        int swaps = 0;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != kthPermutation.charAt(i)) {
                // Find the correct position in original to match kthPermutation[i]
                int idx = i;
                while (original.charAt(idx) != kthPermutation.charAt(i)) {
                    idx++;
                }

                // Perform adjacent swaps to move original[idx] to position i
                while (idx > i) {
                    char temp = original.charAt(idx);
                    original.setCharAt(idx, original.charAt(idx - 1));
                    original.setCharAt(idx - 1, temp);
                    idx--;
                    swaps++;
                }
            }
        }
        return swaps;
    }

    public static int getMinSwaps(String num, int k) {
        // step 1. get the next kth permutation using the next permutation concept...
        char[] chars = num.toCharArray();

        for(int i=0; i<k; i++) {
            int dip = -1;

            for(int j=chars.length-2; j>=0; j--) {
                if(chars[j] < chars[j+1]) {
                    dip = j;
                    break;
                }
            }

            if(dip == -1) {
                reverseArray(chars, 0, chars.length-1);
            }else {
                int l = chars.length-1;

                while(l > dip) {
                    if(chars[l] > chars[dip]) {
                        char temp = chars[l];
                        chars[l] = chars[dip];
                        chars[dip] = temp;
                        break;
                    }
                    l--;
                }
                reverseArray(chars, dip+1, chars.length-1);
            }
        }

        // step 2. get minimum adjacent swaps now
        return getMinimumSwaps(num, chars);
    }

    public static void main(String[] args) {
        System.out.println(getMinSwaps("5489355142", 4));
    }
}
