/**
 * Problem: LRU Cache
 * Platform: LeetCode
 *
 * Approach (Linked List):
 * 1. Use a linked list to store the key-value pairs.
 * 2. Use a map to store the key-value pairs.
 * 3. Use a head and tail node to store the head and tail of the linked list.
 * 4. Use a method to add a node to the head of the linked list.
 * 5. Use a method to remove a node from the tail of the linked list.
 */
/**
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a linked list to store the key-value pairs.
 * 2. We use a map to store the key-value pairs.
 * 3. We use a head and tail node to store the head and tail of the linked list.
 * 4. We use a method to add a node to the head of the linked list.
 * 5. We use a method to remove a node from the tail of the linked list.
 */
import java.util.*;

class Node {
    int key, value;
    Node prev, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private Map<Integer, Node> map;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node removeTail() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);

            map.put(key, newNode);
            addNode(newNode);

            if (map.size() > capacity) {
                Node lru = removeTail();
                map.remove(lru.key);
            }
        }
    }
}
