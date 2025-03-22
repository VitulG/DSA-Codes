package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search;

public class CountNegativeNumbersInASortedMatrix {

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            count += countNegativeNumbers(row);
        }
        return count;
    }
    private static int countNegativeNumbers(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int thisRowCount = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] < 0) {
                thisRowCount += (arr.length - mid - thisRowCount);
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return thisRowCount;
    }

    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][]{
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        }));
    }
}
