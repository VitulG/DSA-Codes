public class MedianOfTwoSortedArrays {
    
    public static double findMedian(int[] arr1, int[] arr2) {

        if(arr1.length > arr2.length) return findMedian(arr2, arr1);

        int size1 = arr1.length;
        int size2 = arr2.length;
        int size = size1 + size2;

        int partition = (size1 + size2 + 1) / 2;
        int lo = 0;
        int hi = size1;

        while(lo <= hi) {

            int mid1 = lo + (hi-lo)/2;
            int mid2 = partition - mid1;

            //assign l1, l2, r1, r2
            int l1 = (mid1 - 1 >= 0) ? arr1[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2 - 1 >= 0) ? arr2[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < size1) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < size2) ? arr2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {

                if(size%2 != 0){
                    return Math.max(l1, l2);
                }
                else{
                    return (Math.max(l1,l2) + Math.min(r1,r2)) * 0.5d; 
                }

            }else if(l1 > r2) {
                hi = mid1-1;
            }else{
                lo = mid1+1;
            }

        }
        return 0.0d;

    }
    public static void main(String[] args) {
        
        System.out.println(findMedian(new int[]{4,6}, new int[]{1,2,3,5}));

    }

}
