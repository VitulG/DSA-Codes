package Data_Structure_Algorithms_Topic_Wise_Questions.stack;

import java.util.Stack;

public class DecodeString {

    /*
        Approach here is two maintain the count of the number of times in which we have to decode that string in which string
                is present inside [] so also we have to maintain the current string till [ what is the state of the string we have
                to take care about things.

                ch == character -> just append that character to the string
                0-9 == character -> make that number
                [ == character -> what number has been made and string has been made just push into their stacks
                ] == character -> so now we have to formed that string take that number from the number stack and append that many times

            TC -> O(n)
            SC -> O(2n)
     */

    public static String decodeString(String str) {
        if(str.isEmpty()) {
            return "";
        }

        Stack<Integer> numberStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder decodedString = new StringBuilder();
        int currentNumber = 0;

        for(char ch : str.toCharArray()) {
            if(Character.isDigit(ch)) {
                currentNumber = (currentNumber * 10) + (ch -'0');
            }else if(ch == '[') {
                numberStack.push(currentNumber);
                currentNumber = 0;
                stringStack.push(decodedString);
                decodedString = new StringBuilder();
            }else if(ch == ']') {
                String temp = decodedString.toString();
                decodedString = stringStack.pop();
                int number = numberStack.pop();

                decodedString.append(temp.repeat(Math.max(0, number)));
            }else {
                decodedString.append(ch);
            }
        }
        return decodedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("2[a3[b]c]"));
    }
}
