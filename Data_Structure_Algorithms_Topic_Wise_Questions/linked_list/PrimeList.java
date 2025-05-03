package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeList {

    /*
        Approach -> to Solve this question, we need to find the prime numbers
        1. to find the prime numbers, I used Sieve of Eratosthenes to get the primes in O(maxValue log log maxVal)
        2. after taking all the primes, I will take the nearest two primes in log n time.
        3. after that, I can take the smallest prime number and add into my result nodes

        TC -> O(n * log curr.val), SC -> (sieve array + prime list + nodes)
     */

    public static boolean[] sieveOfEratosthenes(int maxValue) {
        boolean[] primes = new boolean[maxValue+101];
        Arrays.fill(primes, true);

        primes[0] = primes[1] = false;

        for(int i=2; i*i < maxValue+101; i++) {
            if(primes[i]) {
                for(int j = i*i; j <maxValue+101; j+=i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

    public static int getNearestPrimeNumber(List<Integer> primeNumbers, int value) {
        int pos = -1;
        int low = 0;
        int high = primeNumbers.size()-1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(primeNumbers.get(mid) < value) {
                pos = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        if (pos == -1) {
            return primeNumbers.get(0);
        }
        if (pos + 1 >= primeNumbers.size()) {
            return primeNumbers.get(primeNumbers.size() - 1);
        }

        int currentPrime = primeNumbers.get(pos);
        int nextPrime = primeNumbers.get(pos+1);

        if(Math.abs(currentPrime-value) <= Math.abs(nextPrime-value)) {
            return currentPrime;
        }else {
            return nextPrime;
        }

    }

    public static ListNode primeList(ListNode head) {
        if(head == null) {
            return null;
        }

        int maxValue = Integer.MIN_VALUE;
        ListNode curr = head;

        while(curr != null) {
            maxValue = Math.max(maxValue, curr.val);
            curr = curr.next;
        }

        boolean[] primes = sieveOfEratosthenes(maxValue);

        List<Integer> primeNumbers = new ArrayList<>();

        for(int i=0; i<primes.length; i++) {
            if(primes[i]) {
                primeNumbers.add(i);
            }
        }


        ListNode primeList = new ListNode(-1);
        ListNode tail = primeList;
        curr = head;

        while(curr != null) {
            if(primes[curr.val]) {
                tail.next = new ListNode(curr.val);
            }else {
                // find the nearest prime number
                int nearestPrime = getNearestPrimeNumber(primeNumbers, curr.val);
                tail.next = new ListNode(nearestPrime);
            }
            tail = tail.next;
            curr = curr.next;
        }
        return primeList.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(15);
        head.next.next = new ListNode(20);

        System.out.println(primeList(head));
    }
}
