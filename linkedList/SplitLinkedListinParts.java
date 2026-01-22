/**
 * Problem: Split Linked List in Parts
 * Platform: LeetCode
 *
 * Approach (Linked List):
 * 1. Calculate the size of the linked list.
 * 2. Calculate the base size and the extra nodes.
 * 3. Split the linked list into k parts.
 * 4. If there are extra nodes, distribute them evenly among the parts.
 * 5. If the current node is not null, set the next node to null.
 * 6. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(k)
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int baseSize = size / k;
        int extra = size % k;
        ListNode[] result = new ListNode[k];
        cur = head;

        for (int i = 0; i < k; i++) {
            result[i] = cur;
            int partSize = baseSize;
            if(extra>0){
                partSize++;
                extra--;
            }
            for (int j = 1; j < partSize && cur != null; j++) {
                cur = cur.next;
            }
            if (cur != null) {
                ListNode next = cur.next;
                cur.next = null;
                cur = next;
            }
        }
        return result;
    }
}
