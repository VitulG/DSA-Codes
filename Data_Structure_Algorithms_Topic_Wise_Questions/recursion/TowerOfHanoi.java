package Data_Structure_Algorithms_Topic_Wise_Questions.recursion;

public class TowerOfHanoi {

    public static void getTowerOfHanoiSteps(int disks, int src, int inter, int dst, int[] steps) {
        if(disks == 0) {
            return;
        }
        getTowerOfHanoiSteps(disks-1, src, dst, inter, steps);
        steps[0]++;
        System.out.println("disk "+disks+" is placed from: "+src+" to "+dst+" via "+inter);
        getTowerOfHanoiSteps(disks-1, inter, src, dst, steps);
    }

    public static int towerOfHanoi(int n, int from, int to, int aux) {
        if(n == 0 || n == 1) {
            return n;
        }

        int[] steps = {0};
        getTowerOfHanoiSteps(n, from, aux, to, steps);
        return steps[0];
    }

    public static void main(String[] args) {
        System.out.println(towerOfHanoi(3, 0, 2, 1));
    }
}
