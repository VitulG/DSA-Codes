public class MinimumSwapsRequiredToGroupAllOnesTogetherI {
    public static int minSwaps(int arr[], int n) {
       
        // first count the number of ones

        int totalNumberOfOnes = 0;

        for(int i=0; i<n; i++) {
            if(arr[i] == 1) {
                totalNumberOfOnes++;
            }
        }

        if(totalNumberOfOnes == 0) {
            return -1;
        }

        int countOneInWindow = 0;

        for(int i=0; i<totalNumberOfOnes; i++) {
            if(arr[i] == 1) {
                countOneInWindow++;
            }
        }

        int maxOneWindow = countOneInWindow;

        for(int i=totalNumberOfOnes; i<n; i++) {
            int nextValue = arr[i];
            int prevValue = arr[i - totalNumberOfOnes];

            if(nextValue == 1) {
                countOneInWindow++;
            }

            if(prevValue == 1) {
                countOneInWindow--;
            }

            maxOneWindow = Math.max(maxOneWindow, countOneInWindow);
        }
        return totalNumberOfOnes - maxOneWindow;

    }
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{0}, 1));
    }    
}
