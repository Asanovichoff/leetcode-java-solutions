/**
 * Problem: Insertion Sort List
 * Platform: LeetCode
 *
 * Approach (Linked List):
 * 1. Use a dummy node to store the head of the linked list.
 * 2. Use a loop to iterate through the linked list and insert the nodes in the correct position.
 * 3. Return the head of the linked list.
 */
/**
 * Time Complexity: O(n)

/**
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a dummy node to store the head of the linked list.
 * 2. We use a loop to iterate through the linked list and insert the nodes in the correct position.
 * 3. We return the head of the linked list.
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(5001);
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }

        return dummy.next;
    }
}
