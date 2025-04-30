public class Practice {

    public static int fun(int x, int y) {
        if(y == 0) {
            return 0;
        }
        return x + fun(x, y-1);
    }

    public static void main(String[] args) {
        System.out.println(fun(3,4));
    }
}
