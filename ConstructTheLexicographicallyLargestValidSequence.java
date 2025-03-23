public class ConstructTheLexicographicallyLargestValidSequence {

    public static boolean generateLargestSequence(int[] sequence, int idx, int num, boolean[] isUsed) {
        if(idx == sequence.length) { // maine pure fill kar diya hai array ko isiliye true
            return true;
        }

        if(sequence[idx] != 0) { // agar vo position already filled hai to usse hum skip kar denge aur aage bad jaayenge
            return generateLargestSequence(sequence, idx+1, num, isUsed);
        }

        // start karenge largest number ke sath i.e. 3 if num = 3
        for(int currentNumber = num; currentNumber >= 1; currentNumber--) {
            // check karo ki ye number used nahi hona chaiye
            if(!isUsed[currentNumber]) {

                // next Index according to the condition hai agar number 1 hai to use next index ke liye wahi assign karna hoga
                int nextIndex = (currentNumber == 1) ? idx : idx + currentNumber;

                // check boundary condition and code aksar fat jata hai jab boundary check na ho
                if(nextIndex < sequence.length && sequence[nextIndex] == 0) {
                    sequence[idx] = currentNumber;
                    sequence[nextIndex] = currentNumber;
                    isUsed[currentNumber] = true;

                    // ek place humne fill kar diya ab aage bado
                    if(generateLargestSequence(sequence, idx+1, num, isUsed)) {
                        return true;
                    }

                    // backtrack kar do ki ye number yaha possible hi nahi hai
                    sequence[idx] = 0;
                    sequence[nextIndex] = 0;
                    isUsed[currentNumber] = false;
                }
            }
        }
        return false;
    }

    public static int[] constructDistancedSequence(int num) {
        int size = 2 * num -1;
        int[] largestSequence = new int[size];
        boolean[] isUsed = new boolean[num+1];

        generateLargestSequence(largestSequence, 0, num, isUsed);

        return largestSequence;
    }

    public static void main(String[] args) {
        int[] result = constructDistancedSequence(3);

        for(int num : result) {
            System.out.print(num+" ");
        }

    }
}
