package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class TwoSumIIInputArrayIsSorted {

    public static int[] twoSum(int[] numbers, int target) {
        int le = 0;
        int ri = numbers.length-1;

        while(le < ri) {
            if(numbers[le] + numbers[ri] == target) {
                return new int[]{le+1, ri+1};
            }else if(numbers[le] + numbers[ri] < target) {
                le++;
            }else {
                ri--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = twoSum(new int[]{2,7,11,15}, 91);

        System.out.println(numbers[0]+" "+numbers[1]);
    }
}
