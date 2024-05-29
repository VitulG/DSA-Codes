public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {

    public static String addOne(String str) {
        StringBuilder strSb = new StringBuilder(str);
        int len = strSb.length()-1;

        while(len >= 0 && strSb.charAt(len) != '0') {
            strSb.setCharAt(len, '0');
            len--;
        }
        
        if(len < 0) {
            return new StringBuilder().append("1").append(strSb).toString();
        }else{
            strSb.setCharAt(len, '1');
            return strSb.toString();
        }
    
    }

    public static int numSteps(String str) {
        if(str.length() == 1) {
            return 0;
        }

        int steps = 0;

        while(!str.equals("1")) {
            if(str.charAt(str.length()-1) == '0') {
                str = str.substring(0, str.length()-1);
            }else {
                str = addOne(str);
            }
            steps++;
        }
        return steps;
    }


    public static void main(String[] args) {
        System.out.println(numSteps("1111"));
    }
    
}
