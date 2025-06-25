package Data_Structure_Algorithms_Topic_Wise_Questions.linked_list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


/*
    Approach 1. Deque + HashMap we will use these two DS to implement LRU cache.
                   1. while putting any key we will check if its present if yes that means it is recently used
                        put that in the last in the queue and update the value of the key if different.
                        if the size of the queue equals to its capacity then we have to remove the lease recently
                        used key-value which will be present at the first node in the queue and after that insert
                        the new node.
                   2. while getting a value of the key we must ensure that that key is used so put that key in the
                        the queue last.

                TC -> O(n) // remove operation takes n time
                SC -> O(n) // queue and map is used
 */

public class LRUCache {
    static class Node {
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final Deque<Node>  queue;
    private final Map<Integer, Node> map;
    private final int cacheCapacity;

    public LRUCache(int capacity) {
        this.queue = new ArrayDeque<>();
        this.map = new HashMap<>();
        this.cacheCapacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node keyNode = map.get(key);
        addAndRemoveNode(keyNode);
        return keyNode.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node existingNode = map.get(key);
            existingNode.val = value;
            addAndRemoveNode(existingNode);
        }else {
            if(this.cacheCapacity == this.queue.size()) {
                Node leastRecentlyUsedNode = queue.pollFirst();
                map.remove(leastRecentlyUsedNode.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            queue.addLast(newNode);
        }
    }

    private void addAndRemoveNode(Node node) {
        queue.remove(node);
        queue.addLast(node);
    }
}

class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}