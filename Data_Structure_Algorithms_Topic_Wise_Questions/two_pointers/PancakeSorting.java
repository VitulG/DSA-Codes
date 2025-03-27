package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

    public static void reverseArray(int[] arr, int st, int en) {
        while(st < en) {
            int temp = arr[st];
            arr[st] = arr[en];
            arr[en] = temp;
            st++;
            en--;
        }
    }

    public static List<Integer> pancakeSort(int[] arr) {
        if(arr.length <= 1) {
            return new ArrayList<>();
        }

        int pos = arr.length-1;
        List<Integer> steps = new ArrayList<>();

        while(pos > 0) {
            // step 1. find the max element form the 0 to pos
            int k = 0;
            int ele = arr[0];
            for(int i =0; i <= pos; i++) {
                if(ele < arr[i]) {
                    ele = arr[i];
                    k = i;
                }
            }

            // step 2. reverse the array till k
            if(k != 0) {
                steps.add(k+1);
                reverseArray(arr, 0, k);
            }

            // step 3. reverse array from 0 to pos
            steps.add(pos+1);
            reverseArray(arr, 0, pos);

            pos--;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(pancakeSort(new int[]{3,2,4,1}));
    }
}
