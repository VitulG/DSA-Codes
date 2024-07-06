public class PassThePillow {

    public static int passThePillow(int n, int time) {
        boolean direction = true;
        int pos = 1;

        while(time > 0) {
            if(direction) {
                pos++;
            }else{
                pos--;
            }

            if(pos == n) {
                direction = false;
            }else if(pos == 1) {
                direction = true;
            }
            time--;
        }
        return pos;
    }

    public static void main(String[] args) {
        System.out.println(passThePillow(18, 38));
    }
}
