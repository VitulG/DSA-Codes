package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        ListNode p1 = list1;
        ListNode p2 = list2;

        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            }else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            }
        }

        if(p1 != null) {
            tail.next = p1;
        }

        if(p2 != null) {
            tail.next = p2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode result = mergeTwoList(list1, list2);

        while(result != null) {
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}
