public class NumberOfSeniorCitizens {

    public static int countSeniors(String[] details) {
        if(details == null || details.length == 0) {
            return 0;
        }

        int seniorCitizens = 0;

        for(String detail : details) {
            int first = detail.charAt(11) - '0';
            int second = detail.charAt(12) - '0';

            int age = first*10 + second;

            if(age > 60) {
                seniorCitizens++;
            }
        }
        return seniorCitizens;
    }

    public static void main(String[] args) {
        System.out.println(countSeniors(new String[]{"1313579440F2036","2921522980M5644"}));
    }
    
}
