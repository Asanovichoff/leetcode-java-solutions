/**
 * Problem: LFU Cache
 * Platform: LeetCode
 *
 * Approach (Linked List):
 * 1. Use a linked list to store the key-value pairs.
 * 2. Use a map to store the key-value pairs.
 * 3. Use a method to add a node to the head of the linked list.
 * 4. Use a method to remove a node from the tail of the linked list.
 */
/**

/**
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a linked list to store the key-value pairs.
 * 2. We use a map to store the key-value pairs.
 * 3. We use a method to add a node to the head of the linked list.
 * 
**/
class LFUCache {

    class Node {
        int key, val, freq = 1;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DLL {
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        int size;

        DLL() {
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;

            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    private final int capacity;
    private int minFreq;

    private final Map<Integer, Node> keyToNode;
    private final Map<Integer, DLL> freqToList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();
    }

    public int get(int key) {
        Node node = keyToNode.get(key);

        if (node == null) return -1;

        touch(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        Node node = keyToNode.get(key);

        if (node != null) {
            node.val = value;
            touch(node);
            return;
        }

        if (keyToNode.size() == capacity) {
            Node victim = freqToList.get(minFreq).removeLast();
            keyToNode.remove(victim.key);
        }

        Node newNode = new Node(key, value);

        keyToNode.put(key, newNode);
        freqToList.computeIfAbsent(1, k -> new DLL())
                  .addFirst(newNode);

        minFreq = 1;
    }

    private void touch(Node node) {
        int freq = node.freq;

        DLL oldList = freqToList.get(freq);
        oldList.remove(node);

        if (freq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqToList.computeIfAbsent(node.freq, k -> new DLL())
                  .addFirst(node);
    }
}