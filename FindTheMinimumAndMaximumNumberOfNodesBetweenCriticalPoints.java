public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

    public static int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode curr = head.next;
        ListNode prev = head;
        
        int pos = 1;
        int minDistance = Integer.MAX_VALUE;
        
        int firstCriticalPos = 0;
        int prevCriticalPos  = 0; 

        while(curr.next != null) {
            if((curr.val < prev.val && curr.val < curr.next.val) || (curr.val > prev.val && curr.val > curr.next.val)) {
                if(firstCriticalPos == 0) {
                    firstCriticalPos = pos;
                    prevCriticalPos = pos;
                }else{
                    minDistance = Math.min(minDistance, pos - prevCriticalPos);
                    prevCriticalPos = pos;
                }
            }
            pos++;
            prev = curr;
            curr = curr.next;
        }
        if(minDistance == Integer.MAX_VALUE) {
            return new int[]{-1,-1};
        }

        return new int[]{minDistance, prevCriticalPos-firstCriticalPos};
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);

        int[] values = nodesBetweenCriticalPoints(head);

        System.out.println(values[0] +" "+ values[1]);
    }
}
