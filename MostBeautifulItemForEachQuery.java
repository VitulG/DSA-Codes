import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostBeautifulItemForEachQuery {

    public static int getMaximumBeauty(int priceQuery, List<Integer> price, List<Integer> beauty) {
        int maxBeauty = 0;

        int lo = 0;
        int hi = price.size()-1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(price.get(mid) <= priceQuery) {
                maxBeauty = beauty.get(mid);
                lo = mid+1;
            }else{
                hi = mid - 1;
            }
        }
        return maxBeauty;
    }

    public static int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        List<Integer> price = new ArrayList<>();
        List<Integer> beauty = new ArrayList<>();

        price.add(items[0][0]);
        beauty.add(items[0][1]);

        int maxBeautySoFar = items[0][1];

        for(int i = 1; i<items.length; i++) {
            int currPrice = items[i][0];
            maxBeautySoFar = Math.max(maxBeautySoFar, items[i][1]);

            price.add(currPrice);
            beauty.add(maxBeautySoFar);
        }

        int[] ans = new int[queries.length];
        int idx = -1;

        for(int query : queries) {
            ans[++idx] = getMaximumBeauty(query, price, beauty);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] result = maximumBeauty(new int[][]{{1,2},{3,2},{2,4},{5,6},{3,5}}, new int[]{1,2,3,4,5,6});

        for(int num : result) {
            System.out.print(num+" ");
        }
    }
}
