package Data_Structure_Algorithms_Topic_Wise_Questions.heaps;

public class BuildingAMinHeap {

    public static void heapify(int[] arr, int idx) {
        int len = arr.length;
        int smallest = idx;

        int leftIdx = 2*smallest + 1;
        int rightIdx = 2*smallest + 2;

        if(leftIdx < len && arr[leftIdx] < arr[smallest]) {
            smallest = leftIdx;
        }

        if(rightIdx < len && arr[rightIdx] < arr[smallest]) {
            smallest = rightIdx;
        }

        if(smallest != idx) {
            int temp = arr[smallest];
            arr[smallest] = arr[idx];
            arr[idx] = temp;

            heapify(arr, smallest);
        }
    }

    public static void buildHeap(int[] arr) {
        int len = arr.length;

        for(int i = (len/2)-1; i>=0; i--) {
            heapify(arr, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 10, 3, 5, 1};
        buildHeap(arr);
        for(int num : arr) {
            System.out.print(num +" ");
        }
    }
}
