public class CountTotalNumberOfColoredCells {

    public static long coloredCells(int num) {
        if(num == 1) {
            return 1L;
        }
        return 2L * (num-1) * num + 1;
    }

    public static void main(String[] args) {
        System.out.println(coloredCells(7));
    }
}
