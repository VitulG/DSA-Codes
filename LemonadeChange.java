public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        if(bills.length == 0) {
            return false;
        }

        int five=0, ten =0;

        for(int bill : bills) { 
            if(bill == 5) {
                five++;
            }else if(bill == 10) {
                if(five == 0) {
                    return false;
                }else {
                    ten++;
                    five--;
                }
            }else if(bill == 20) {
                if(ten > 0 && five > 0) {
                    ten--;
                    five--;
                }else if(five >= 3) {
                    five -= 3;
                }else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,10,10,20}));        
    }
}