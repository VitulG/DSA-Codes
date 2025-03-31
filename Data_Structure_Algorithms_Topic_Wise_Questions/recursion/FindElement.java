package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class FindElement {

    public static boolean checkElementPresent(int[] arr, int idx, int target) {
        if(idx >= arr.length) {
            return false;
        }

        if(arr[idx] == target) {
            return true;
        }

        return checkElementPresent(arr, idx+1, target);

    }

    public static boolean isElementPresent(int[] arr, int num) {
        return checkElementPresent(arr, 0, num);
    }

    public static void main(String[] args) {
        System.out.println(isElementPresent(new int[]{1,2,3,4,5}, 13));
    }
}
