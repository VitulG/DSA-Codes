import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {

    public static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            for(int j = i+1; j<nums.length; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        int tuples = 0;

        for(int count : productCount.values()) {
            if(count > 1) {
                tuples += ((count * (count-1)) / 2) * 8;
            }
        }
        return tuples;
    }

    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{1,2,4,5,10}));
    }
}
