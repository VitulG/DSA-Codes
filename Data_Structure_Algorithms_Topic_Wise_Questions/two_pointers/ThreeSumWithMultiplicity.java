package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumWithMultiplicity {

    public static int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int MOD = 1000000007;

        long tuples = 0;

        for(int i=0; i<arr.length-2; i++) {
            int j = i+1;
            int k = arr.length-1;

            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target) {
                    if(arr[j] == arr[k]) {
                        tuples = (tuples + (k - j + 1L) * (k - j) / 2)%MOD;
                        break;
                    }else {
                        int left = 1, right = 1;
                        while (j + 1 < k && arr[j] == arr[j + 1]) {
                            left++;
                            j++;
                        }
                        while (k - 1 > j && arr[k] == arr[k - 1]) {
                            right++;
                            k--;
                        }
                        tuples = (tuples + (long) left * right) % MOD;
                        j++;
                        k--;
                    }
                }else if(sum < target) {
                    j++;
                }else {
                    k--;
                }
            }
        }
        return (int) tuples;

    }

    public static void main(String[] args) {
        System.out.println(threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5}, 8));
    }
}
