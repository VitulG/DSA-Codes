public class StudentAttendanceRecordI {

    public static boolean checkRecord(String str) {
        int countAbsent = 0;

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == 'A') {
                countAbsent++;
            }

            if(countAbsent >= 2) {
                return false;
            }
        }

        int consecutiveLate = (str.charAt(0) == 'L') ? 1 : 0;

        for(int i=1; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == 'L') {
                consecutiveLate++;

                if(consecutiveLate >= 3) {
                    return false;
                }
            }else if(ch != 'L') {
                consecutiveLate = 0;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(checkRecord("AA"));   
    }    
}
