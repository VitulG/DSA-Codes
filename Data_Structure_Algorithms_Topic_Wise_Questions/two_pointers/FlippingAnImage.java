package Data_Structure_Algorithms_Topic_Wise_Questions.two_pointers;

import java.util.Arrays;

public class FlippingAnImage {

    public static void flipImage(int[][] image, int row, int st, int en) {
        while(st < en) {
            int temp = image[row][st];
            image[row][st] = image[row][en];
            image[row][en] = temp;
            st++;
            en--;
        }
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        // step 1. flip the matrix using two pointers
        for(int i=0; i<image.length; i++) {
            flipImage(image, i, 0, image[i].length-1);
        }

        // step 2. invert the image now
        for(int i=0; i<image.length; i++) {
            for(int j=0; j<image[i].length; j++) {
                image[i][j] = (image[i][j] == 0) ? 1 : 0;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] newImage = flipAndInvertImage(new int[][]{
                {1,1,0},
                {1,0,1},
                {0,0,0}
        });

        for(int[] row : newImage) {
            System.out.println(Arrays.toString(row));
        }
    }
}
