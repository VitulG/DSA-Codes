public class CheckIfNumberIsASumOfPowersOfThree {

    public static boolean checkPowersOfThree(int num) {
        int pow = -1;
        int currNum = 1;

        while(currNum <= num) {
            currNum *= 3;
            pow++;
        }

        while(num != 0 && pow >= 0) {
            if(num - (int) Math.pow(3, pow) >= 0) {
                num -= (int) Math.pow(3, pow);

                if(num == 0) {
                    return true;
                }
            }
            pow--;
        }
        return false;
    }

    public static boolean checkPowersOfThreeSecondSolution(int num) {
        while(num != 0) {
            if(num%3 == 2) {
                return false;
            }
            num /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(91));
        System.out.println(checkPowersOfThree(77));
        System.out.println(checkPowersOfThreeSecondSolution(21));
        System.out.println(checkPowersOfThreeSecondSolution(12));
    }
}
