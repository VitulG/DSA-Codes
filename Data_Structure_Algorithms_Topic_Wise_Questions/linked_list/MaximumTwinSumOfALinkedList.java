package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class MaximumTwinSumOfALinkedList {

    public static ListNode findMiddleNode(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;

        while(hare != null && hare.next.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return tortoise;
    }

    public static ListNode reverseNewList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static int pairSum(ListNode head) {
        if(head == null) {
            return 0;
        }

        ListNode middle = findMiddleNode(head);
        ListNode newList = middle.next;
        middle.next = null;

        newList = reverseNewList(newList);

        ListNode fp = head;
        ListNode sp = newList;

        int maxTwinSum = Integer.MIN_VALUE;

        while(fp != null && sp != null) {
            maxTwinSum = Math.max(maxTwinSum, (fp.val + sp.val));
            fp = fp.next;
            sp = sp.next;
        }
        return maxTwinSum;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(pairSum(head));

    }
}
