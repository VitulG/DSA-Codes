public class CheckIfArrayPairsAreDivisibleByK {
    public static boolean canArrange(int[] arr, int k) {
        int[] remainders = new int[k];

        for(int ele : arr) {
            int remainder = ((ele%k)+k)%k; // handles negative numbers
            remainders[remainder]++;
        }

        for(int i=1; i<remainders.length; i++) {
            if(remainders[i] != remainders[k-i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canArrange(new int[]{1,2,3,4,5,10,6,7,8,9}, 5));
    }
}
