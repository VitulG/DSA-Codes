public class NumberComplement {

    public static int findComplement(int num) {
        int till = 0;
        int temp = num;

        while(temp != 0) {
            till++;
            temp >>= 1;
        }

        int ans = 0;

        for(int i= 0; i<till; i++) {
            if((num&1<<i) == 0) {
                ans |= 1<<i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
