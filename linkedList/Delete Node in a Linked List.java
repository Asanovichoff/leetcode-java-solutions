/**
 * Problem: Delete Node in a Linked List
 * Platform: LeetCode
 *
 * Approach (Linked List):
 * 1. Use a linked list to delete a node.
 * 2. Use a loop to iterate through the linked list and delete the node.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)

/**
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a linked list to delete a node.
 * 2. We use a loop to iterate through the linked list and delete the node.
 * 3. We return the result.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode cur = node;
        while (cur.next.next != null) {
            cur.val = cur.next.val;
            cur = cur.next;
        }
        cur.val = cur.next.val;
        cur.next = null;
    }
}