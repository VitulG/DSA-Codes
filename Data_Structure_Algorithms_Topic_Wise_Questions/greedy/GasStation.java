package Data_Structure_Algorithms_Topic_Wise_Questions.greedy;

public class GasStation {

    public static int startStation(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for(int g : gas) {
            totalGas += g;
        }

        for(int c : cost) {
            totalCost += c;
        }

        if(totalGas < totalCost) {
            return -1;
        }

        int startStation = 0;
        int currentGas = 0;

        for(int i=0; i<gas.length; i++) {
            currentGas += gas[i] - cost[i];

            if(currentGas < 0) {
                startStation = i+1;
                currentGas = 0;
            }
        }
        return startStation;
    }

    public static void main(String[] args) {
        System.out.println(startStation(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
