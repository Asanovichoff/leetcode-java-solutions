/**
class Solution {
 * Problem: Merge k Sorted Lists
 * Platform: LeetCode
 *
 * Approach (Linked List):
 * 1. Use a min heap to store the nodes.
 * 2. Use a loop to iterate through the lists and store the nodes in the min heap.
 * 3. Return the merged list.
 */
/**
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 * 
 * Explanation:
 * 1. We use a min heap to store the nodes.
 * 2. We use a loop to iterate through the lists and store the nodes in the min heap.
 * 3. We return the merged list.
 */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val-b.val);
        for (ListNode node : lists) {
            if (node != null) minHeap.offer(node);
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode pointer = dummyNode;

        while (minHeap.size()>0) {
            ListNode cur = minHeap.poll();
            pointer.next = cur;
            if (cur.next != null) {
                minHeap.offer(cur.next);
                cur.next = null;
            }
            pointer = pointer.next;
        }
        return dummyNode.next;
    }
}