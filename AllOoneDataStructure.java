import java.util.*;

class AllOne {

    static class DoublyNode {
        int strCount;
        List<String> keys;
        DoublyNode prev;
        DoublyNode next;

        public DoublyNode(int strCount) {
            this.strCount = strCount;
            this.keys = new LinkedList<>();
        }
    }

    private final Map<String, DoublyNode> stringCount;
    DoublyNode head;
    DoublyNode tail;

    public AllOne() {
        stringCount = new HashMap<>();
        head = new DoublyNode(0);
        tail = head;
    }

    public void inc(String key) {
        if (!stringCount.containsKey(key)) {
            if (head.next == null || head.next.strCount != 1) {
                addNode(head, 1);
            }
            head.next.keys.add(key);
            stringCount.put(key, head.next);
        } else {
            DoublyNode node = stringCount.get(key);
            int currCount = node.strCount;

            if (node.next == null || node.next.strCount != currCount + 1) {
                addNode(node, currCount + 1);
            }
            node.next.keys.add(key);
            stringCount.put(key, node.next);
            node.keys.remove(key);

            if (node.keys.isEmpty()) {
                removeNode(node);
            }
        }
    }

    public void dec(String key) {
        DoublyNode node = stringCount.get(key);
        int currCount = node.strCount;

        if (currCount == 1) {
            stringCount.remove(key);
        } else {
            if (node.prev.strCount != currCount - 1) {
                addNode(node.prev, currCount - 1);
            }
            node.prev.keys.add(key);
            stringCount.put(key, node.prev);
        }
        node.keys.remove(key);
        if (node.keys.isEmpty()) {
            removeNode(node);
        }
    }

    private void addNode(DoublyNode prevNode, int count) {
        DoublyNode newNode = new DoublyNode(count);
        newNode.next = prevNode.next;
        if (prevNode.next != null) {
            prevNode.next.prev = newNode;
        }
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (prevNode == tail) {
            tail = newNode;
        }
    }

    private void removeNode(DoublyNode node) {
        node.prev.next = node.next;
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (tail == node) {
            tail = node.prev;
        }
    }

    public String getMaxKey() {
        if (tail == head) {
            return "";
        }
        return tail.keys.getFirst();
    }

    public String getMinKey() {
        if (head.next == null) {
            return "";
        }
        return head.next.keys.getFirst();
    }
}


public class AllOoneDataStructure {
    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("world");
        System.out.println(allOne.getMaxKey()); // Output: "world"
        allOne.dec("world");
        System.out.println(allOne.getMaxKey()); // Output: "hello"
        allOne.inc("leetcode");
        System.out.println(allOne.getMinKey()); // Output: "hello"
        allOne.dec("leetcode");
        System.out.println(allOne.getMinKey()); // Output: ""
    }
}
