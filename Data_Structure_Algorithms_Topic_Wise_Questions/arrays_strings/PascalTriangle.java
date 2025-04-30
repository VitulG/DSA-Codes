package Data_Structure_Algorithms_Topic_Wise_Questions.arrays_strings;

import java.util.ArrayList;

public class PascalTriangle {

    public static ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> nthPascalTriangleRow = new ArrayList<>();
        nthPascalTriangleRow.add(1);

        for(int i=1; i<n; i++) {
            ArrayList<Integer> currentPascalRow = new ArrayList<>();
            currentPascalRow.add(1);

            for(int j= 1; j<nthPascalTriangleRow.size(); j++) {
                currentPascalRow.add(nthPascalTriangleRow.get(j-1) + nthPascalTriangleRow.get(j));
            }
            currentPascalRow.add(1);
            nthPascalTriangleRow = currentPascalRow;
        }
        return nthPascalTriangleRow;
    }

    public static void main(String[] args) {
        System.out.println(nthRowOfPascalTriangle(10));
    }
}
