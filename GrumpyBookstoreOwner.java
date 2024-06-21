public class GrumpyBookstoreOwner {

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int len = customers.length;
        int customerSatisfiedNow = 0;

        for(int i=0; i<len; i++) {
            if(grumpy[i] == 0) {
                customerSatisfiedNow += customers[i];
            }
        }

        int maxCustomerSatisfied = 0;

        // process first window
        for(int i=0; i<minutes; i++) {
            if(grumpy[i] == 1) {
                maxCustomerSatisfied += customers[i];
            }
        }

        int tillCustomerSatisfied = maxCustomerSatisfied;

        // process for the rest of the windows
        for(int i=minutes; i<len; i++) {
            if(grumpy[i] == 1) {
                tillCustomerSatisfied += customers[i];
            }

            if(grumpy[i-minutes] == 1) {
                tillCustomerSatisfied -= customers[i-minutes];
            }

            maxCustomerSatisfied = Math.max(tillCustomerSatisfied, maxCustomerSatisfied);
        }
        return maxCustomerSatisfied + customerSatisfiedNow;

    }

    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }
}
