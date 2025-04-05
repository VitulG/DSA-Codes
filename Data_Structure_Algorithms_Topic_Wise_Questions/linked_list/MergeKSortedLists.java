package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (ListNode list : lists) {
            if(list != null) {
                queue.offer(list);
            }
        }

        while(!queue.isEmpty()) {
            ListNode currList = queue.poll();
            tail.next = currList;
            tail = tail.next;

            if(currList.next != null) {
                queue.offer(currList.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);

        ListNode head3 = new ListNode(6);
        head3.next = new ListNode(9);
        head3.next.next = new ListNode(10);
        head3.next.next.next = new ListNode(15);

        ListNode mergedList = mergeKLists(new ListNode[]{head1, head2, head3});

        System.out.println(mergedList);
    }
}
