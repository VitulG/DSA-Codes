package Data_Structure_Algorithms_Topic_Wise_Questions.binary_search;

public class MedianOfTwoSortedArrays {

    /*
        Approach 1. Brute force, we can merge these sorted arrays and then find median in O(1) time.
                    TC -> O(m + n)
                    SC -> O(m + n)

        Approach 2. Using Binary Search, we can apply binary search on the min array so that we can archive
                        min time complexity.
                    1. find the total length of the num1 and num2 elements.
                    2. find the partition in which we get the middle element(s).
                    3. Use Binary Search on the mini array and get the elements from mid.
                    4. for the remaining array from num2 will be partition - mid.
                    5. get the l1, l2, r1, r2 so we can find the middle element easily.
                    6. if l1 <= r2 && l2 <= r1 then it will be sorted array and now we can find median easily.
                          Odd case -> Math.max(l1, l2) // since middle will be in the left part
                          Even case -> Math.max(l1, l2) + Math.min(r1, r2) / 2.0;
                    7. if l1 > r2 that means sorted order is not there and we have a large number on left side
                            so we have to reduce elements from left side -> mid -1.
                    8. else go to right side i.e. increase the elements in left side.
                    9. finally return the median if found if not return 0.0d;

                    TC -> O(log(min(arr1, arr2)))
                    SC -> O(1)
     */

    public static double findMedianSortedArrays(int[] nums1,   int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // for to achieve the TC of log(min(m,n))
        }

        int low = 0;
        int high = nums1.length;

        int totalElements = (nums1.length + nums2.length + 1) /2;

        while(low <= high) {
            int partitionElementsFromFirst = low + (high - low) / 2;
            int partitionElementsFromSecond = totalElements - partitionElementsFromFirst;

            int l1 = (partitionElementsFromFirst-1 >= 0) ? nums1[partitionElementsFromFirst-1] : Integer.MIN_VALUE;
            int l2 = (partitionElementsFromSecond-1 >= 0) ? nums2[partitionElementsFromSecond-1] : Integer.MIN_VALUE;
            int r1 = (partitionElementsFromFirst < nums1.length) ? nums1[partitionElementsFromFirst] : Integer.MAX_VALUE;
            int r2 = (partitionElementsFromSecond < nums2.length) ? nums2[partitionElementsFromSecond] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                if(((nums1.length + nums2.length) & 1) != 0) {
                    return Math.max(l1, l2);
                }else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }else if(l1 > r2) {
                high = partitionElementsFromFirst - 1;
            }else {
                low = partitionElementsFromFirst + 1;
            }
        }
        return 0.0d;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}
