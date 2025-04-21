package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) {
            return;
        }

        int i = m-1;
        int j = n-1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0) {
            if(nums2[j] >= nums1[i]) {
                nums1[k--] = nums2[j--];
            }else {
                nums1[k--] = nums1[i--];
            }
        }

        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }

    public static void main(String[] args) {

    }
}
