/**
 * Problem: Delete the Middle Node of a Linked List
 * Platform: LeetCode
 *
 * Approach (Linked List):
 * 1. Use a linked list to delete the middle node of the linked list.
 * 2. Use a loop to iterate through the linked list and delete the middle node.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)

/**
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a linked list to delete the middle node of the linked list.
 * 2. We use a loop to iterate through the linked list and delete the middle node.
 * 3. We return the result.
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null) return head;
        if(head.next == null){
            head = null;
            return head;
        }
        else if(head.next.next == null){
            head.next = null;
            return head;
        }
        ListNode prev = new ListNode(-1, head);
        ListNode cur = head;
        ListNode fast = head;
        while(fast!= null && fast.next!= null){
            fast = fast.next.next;
            cur = cur.next;
            prev = prev.next;
        }
        fast = cur.next;
        prev.next = fast;
        return head;
        
    }
}
