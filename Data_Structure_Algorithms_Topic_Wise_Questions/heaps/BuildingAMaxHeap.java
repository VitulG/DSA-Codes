package Data_Structure_Algorithms_Topic_Wise_Questions.heaps;

public class BuildingAMaxHeap {

    public static void maxheapify(int[] arr, int idx) {
        int greatest = idx;
        int leftChildIdx = 2 * greatest + 1;
        int rightChildIdx = 2 * greatest + 2;

        if(leftChildIdx < arr.length && arr[leftChildIdx] > arr[greatest]) {
            greatest = leftChildIdx;
        }

        if(rightChildIdx < arr.length && arr[rightChildIdx] > arr[greatest]) {
            greatest = rightChildIdx;
        }

        if(greatest != idx) {
            int temp = arr[idx];
            arr[idx] = arr[greatest];
            arr[greatest] = temp;

            maxheapify(arr, greatest); // sub tree ko balance karne ke liye call kiya
        }

    }

    public static void buildMaxHeap(int[] arr, int len) {
        int startIndex = (len/2) - 1;

        for(int i = startIndex; i>= 0; i--) {
            maxheapify(arr, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,9,19,11,17,8};
        buildMaxHeap(arr, arr.length);
        for(int num : arr) {
            System.out.print(num+" ");
        }
    }
}
