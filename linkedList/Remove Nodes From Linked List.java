/**
 * Problem: Remove Nodes From Linked List
 * Platform: LeetCode
 *
 * Approach (Linked List):
 * 1. Use a recursive function to remove the nodes from the linked list.
 * 2. Return the head of the linked list.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null) return head;
        head.next = removeNodes(head.next);
        return head.next!= null && head.next.val>head.val ? head.next : head;
               
    }
}