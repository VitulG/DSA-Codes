public class SingleNumberIII {

    public static int[] singleNumber(int[] arr) {
        int xor = 0;

        for(int ele :  arr) {
            xor ^= ele;
        }

        // find first set bit in the xor
        int firstSetBit = 0;
        for(int i=0; i<31; i++) {
            if((xor&(1<<i)) != 0) {
                firstSetBit = i;
                break;
            }
        }
        
        int first =0;
        int second = 0;

        for(int num : arr) {
            if((num&(1<<firstSetBit)) == 0) {
                first ^= num;
            }else{
                second ^= num;
            }
        }
        return new int[]{first, second};
    }


    public static void main(String[] args) {
        int[] result = singleNumber(new int[]{0,-1});
        for(int i : result) {
            System.out.print(i+" ");
        }
    }
}
