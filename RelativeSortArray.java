public class RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freqArr = new int[1001];

        for(int num : arr1) {
            freqArr[num]++;
        }

        int[] ans = new int[arr1.length];
        int idx = -1;

        for(int i=0; i<arr2.length; i++) {
            int ele = arr2[i];

            while(freqArr[ele]-- > 0) {
                ans[++idx] = ele;
            }
        }

        for(int i=0; i<freqArr.length; i++) {
            while(freqArr[i]-- > 0) {
                ans[++idx] = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] result = relativeSortArray(new int[]{28,6,22,8,44,17,0}, new int[]{22,28,8,6});

        for(int i : result) {
            System.out.print(i+" ");
        }
    }
}