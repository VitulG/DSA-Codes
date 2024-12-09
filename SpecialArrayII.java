public class SpecialArrayII {

    public static boolean[] isArraySpacial(int[] nums, int[][] queries) {
        // store the parity first of the array
        boolean[] parity = new boolean[nums.length];

        for(int i=0; i<nums.length-1; i++) {
            parity[i] = (nums[i]%2 != nums[i+1]%2);
        }

        // step 2. using prefix sum for calculating the no. of true values in the parity
        int[] preParity = new int[parity.length+1];

        for(int i=0; i< parity.length; i++) {
            preParity[i+1] = preParity[i] + ((parity[i]) ? 1 : 0);
        }

        boolean[] ans = new boolean[queries.length];
        int idx = 0;

        // step 3. calculate the parity if the parity is valid then it will be the same

        for(int[] query : queries) {
            int from = query[0];
            int to = query[1];

            if(preParity[to] - preParity[from] == to - from) {
                ans[idx++] = true;
            }else{
                ans[idx++] = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        boolean[] result = isArraySpacial(new int[]{4,3,1,6}, new int[][]{
                {0,2},
                {2,3}
        });

        for(boolean r : result) {
            System.out.print(r+" ");
        }
    }
}
