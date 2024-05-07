public class DoubleANumberRepresentedAsALinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode doubleIt(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode reverseList = reverseList(head);
        int carry = 0;
        ListNode curr = reverseList;
        ListNode prev = null;

        while(curr != null) {
            int doubleValue = curr.val*2+carry;
            curr.val = doubleValue%10;
            carry = doubleValue/10;
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = prev;
            prev = newNode;
        }
        return prev;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        

        ListNode doubleList = doubleIt(head);

        ListNode curr = doubleList;

        while(curr != null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
    }
    
}
