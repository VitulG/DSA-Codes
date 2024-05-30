public class CountTripletsThatCanFormTwoArraysOfEqualXOR {

    public static int countTriplets(int[] arr) {
        int[] prefixXor = new int[arr.length+1];

        for(int i=0; i<arr.length; i++) {
            prefixXor[i+1] = prefixXor[i]^arr[i];
        }

        int ans = 0;

        for(int i=0; i<prefixXor.length; i++) {
            for(int k=i+1; k<prefixXor.length; k++) {
                if(prefixXor[i] == prefixXor[k]) {
                    ans += (k-i-1);
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{1,1,1,1,1}));
    }
    
}
