public class MinimizedMaximumOfProductsDistributedToAnyStore {

    public static boolean isPossibleToDistributeProduct(int stores, int[] quantities, int minProducts) {
        for(int quantity : quantities) {
            int neededStores = (int) Math.ceil((double) quantity / minProducts);
            stores -= neededStores;

            if(stores < 0) {
                return false;
            }
        }
        return true;
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int lo = 1;
        int hi = quantities[0];

        for(int quantity : quantities) {
            hi = Math.max(hi, quantity);
        }

        int minProducts = -1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) /2;
            if(isPossibleToDistributeProduct(n, quantities, mid)) {
                minProducts = mid;
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return minProducts;
    }

    public static void main(String[] args) {

    }
}
