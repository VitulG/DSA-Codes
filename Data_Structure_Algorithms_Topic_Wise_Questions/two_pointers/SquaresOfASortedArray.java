package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class SquaresOfASortedArray {

    public static int[] sortedSquares(int[] nums) {
        // Two pointer will not work to sort an array. we must use any sorting algorithm to sort an array.
        int le = 0;
        int ri = nums.length-1;

        int[] squares = new int[nums.length];
        int idx = nums.length-1;

        while(le <= ri) {
            int leftSquare = nums[le] * nums[le];
            int rightSquare = nums[ri] * nums[ri];

            if(leftSquare > rightSquare) {
                squares[idx] = leftSquare;
                le++;
            }else {
                squares[idx] = rightSquare;
                ri--;
            }
            idx--;
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] sortedResult = sortedSquares(new int[]{-4,-1,0,3,10});

        for(int num : sortedResult) {
            System.out.print(num+" ");
        }

    }
}
