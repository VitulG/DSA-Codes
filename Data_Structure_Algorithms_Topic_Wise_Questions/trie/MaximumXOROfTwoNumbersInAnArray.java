package Data_Structure_Algorithms_Topic_Wise_Questions.trie;

public class MaximumXOROfTwoNumbersInAnArray {
    private static final TrieBitNode root = new TrieBitNode(2);

    public static void insertInTrie(int num, int bits) {
        TrieBitNode curr = root;

        for(int bit = bits-1; bit >= 0; bit--) {
            if(((num&(1<<bit)) != 0)) { // that means it's a set bit
                if(curr.children[1] == null) {
                    curr.children[1] = new TrieBitNode(1);
                }
                curr = curr.children[1];
            }else {
                if(curr.children[0] == null) {
                    curr.children[0] = new TrieBitNode(0);
                }
                curr = curr.children[0];
            }
        }
    }

    public static int getMaxXor(int num, int bits) {
        TrieBitNode curr = root;
        int currXor = 0;

        for(int bit = bits-1; bit >= 0; bit--) {
            if((num&(1<<bit)) != 0) { //set bit
                if(curr.children[0] != null) {
                    currXor |= (1<<bit);
                    curr = curr.children[0];
                }else {
                    curr = curr.children[1];
                }
            }else {
                if(curr.children[1] != null) {
                    currXor |= (1<<bit);
                    curr = curr.children[1];
                }else {
                    curr = curr.children[0];
                }
            }
        }
        return currXor;
    }

    public static int maxXor(int[] nums) {
        // Optimal approach can be using trie data structure

        // step 1. find the max element
        int maxElement = Integer.MIN_VALUE;
        for(int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        // step 2. find the no. of bits in a max element
        int bits = 0;
        while(maxElement != 0) {
            bits++;
            maxElement >>= 1;
        }

        // step 3. insert all the numbers in the trie
        for(int num : nums) {
            insertInTrie(num, bits);
        }

        // step 4. finally, we can find the max xor for the array
        int maxXor = Integer.MIN_VALUE;

        for(int num : nums) {
            maxXor = Math.max(maxXor, getMaxXor(num, bits));
        }
        return maxXor;
    }

    public static void main(String[] args) {
        System.out.println(maxXor(new int[]{7,6,2}));
    }
}
