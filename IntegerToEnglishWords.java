public class IntegerToEnglishWords {
    private static String[] oneToTen = {"","One","Two","Three","Four","Five","Six","Seven","Eight", "Nine", "Ten"};
    private static String[] elevenToTwenty = {"","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Ninteen"};
    private static String[] restOftheWord = {"", "", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"}; 

    public static String findEnglishWordRepresentation(int num) {
        if (num == 0) {
            return "";
        }
        if (num <= 10) {
            return oneToTen[num];
        }
        if (num < 20) {
            return elevenToTwenty[num % 10];
        }
        if (num < 100) {
            return restOftheWord[num / 10] + (num % 10 != 0 ? " " + oneToTen[num % 10] : "");
        }
        if (num < 1000) {
            return oneToTen[num / 100] + " Hundred" + (num % 100 != 0 ? " " + findEnglishWordRepresentation(num % 100) : "");
        }
        if (num < 1000000) {
            return findEnglishWordRepresentation(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + findEnglishWordRepresentation(num % 1000) : "");
        }
        if (num < 1000000000) {
            return findEnglishWordRepresentation(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + findEnglishWordRepresentation(num % 1000000) : "");
        }
        return findEnglishWordRepresentation(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + findEnglishWordRepresentation(num % 1000000000) : "");
    }

    public static String numberToWords(int num) {
        if(num < 0) {
            return "";
        }

        if(num == 0) {
            return "Zero";
        }
        return findEnglishWordRepresentation(num);
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(123456));
    }
}