package Leetcode_75.arrays_strings;

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) {
            return true;
        }

        if(flowerbed.length == 1) {
            return flowerbed[0] == 0 && n <= 1;
        }

        int flowerPlanted = 0;

        for(int i=0; i<flowerbed.length; i++) {
            if(i == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                flowerPlanted++;
                flowerbed[i] = 1;
            }else if(i > 0 && i < flowerbed.length-1 && flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                flowerPlanted++;
                flowerbed[i] = 1;
            }else if(i == flowerbed.length-1 && flowerbed[i] == 0 && flowerbed[i-1] == 0) {
                flowerPlanted++;
                flowerbed[i] = 1;
            }

            if(flowerPlanted == n) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,1,0,1,1,1,0,0,0,0,1}, 3));
    }
}
