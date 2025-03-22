package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        prefixProduct[0] = 1;

        for(int i=1; i<nums.length; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }

        int[] suffixProduct = new int[nums.length];
        suffixProduct[nums.length-1] = 1;

        for(int j = nums.length-2; j>=0; j--) {
            suffixProduct[j] = suffixProduct[j+1] * nums[j+1];
        }

        int[] product = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            product[i] = prefixProduct[i] * suffixProduct[i];
        }

        return product;
    }

    public static void main(String[] args) {
        int[] ans = productExceptSelf(new int[]{1,2,3,4});

        Arrays.stream(ans)
                .forEach(System.out::print);
    }
}
