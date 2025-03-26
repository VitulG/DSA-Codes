package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int idx = 0;

        for(int num : nums) {
            if(num != val) {
                nums[idx++] = num;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
