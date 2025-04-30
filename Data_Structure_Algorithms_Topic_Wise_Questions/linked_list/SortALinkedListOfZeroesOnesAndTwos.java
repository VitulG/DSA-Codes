package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class SortALinkedListOfZeroesOnesAndTwos {

    public static ListNode segregate(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode zeroes = new ListNode(-1);
        ListNode ones = new ListNode(-1);
        ListNode twos = new ListNode(-1);

        ListNode zeroPointer = zeroes;
        ListNode onePointer = ones;
        ListNode twoPointer = twos;

        ListNode curr = head;

        while(curr != null) {
            if(curr.val == 0) {
                zeroPointer.next = curr;
                zeroPointer = zeroPointer.next;
                curr = curr.next;
            }else if(curr.val == 1) {
                onePointer.next = curr;
                onePointer = onePointer.next;
                curr = curr.next;
            }else {
                twoPointer.next = curr;
                twoPointer = twoPointer.next;
                curr = curr.next;
            }
        }

        zeroPointer.next = null;
        onePointer.next = null;
        twoPointer.next = null;

        if (zeroes.next != null) {
            zeroPointer.next = ones.next != null ? ones.next : twos.next;
            onePointer.next = twos.next;
            return zeroes.next;
        } else if (ones.next != null) {
            onePointer.next = twos.next;
            return ones.next;
        } else {
            return twos.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(2);

        System.out.println(segregate(head));
    }
}
