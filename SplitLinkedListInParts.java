public class SplitLinkedListInParts {

    public static ListNode[] splitListToParts(ListNode head, int k) {
        int numberOfNodes = 0;
        ListNode curr = head;

        while(curr != null) {
            numberOfNodes++;
            curr = curr.next;
        }

        ListNode[] nodes = new ListNode[k];

        int minNodesInABucket = numberOfNodes / k;
        int extraNodes = numberOfNodes % k;
        curr = head;

        for(int i=0; i<k; i++) {
            ListNode prev = null;
            int nodeNumber = 1;
            nodes[i] = curr;
            while(curr != null && nodeNumber <= minNodesInABucket) {
                nodeNumber++;
                prev = curr;
                curr = curr.next;
            }

            if(extraNodes > 0) {
                extraNodes--;
                prev = curr;
                curr = curr.next;
            }

            if(prev!=null) {
                prev.next = null;
            }
        }

        return nodes;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        ListNode[] result = splitListToParts(head, 4);

        for(ListNode listNode : result) {
            ListNode curr = listNode;
            while(curr!=null) {
                System.out.print(curr.val+" ");
                curr = curr.next;
            }
            System.out.println();
        }
    }
}
