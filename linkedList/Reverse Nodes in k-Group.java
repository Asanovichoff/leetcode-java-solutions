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

/** problem: Reverse Nodes in k-Group
 * 
 * approach 1: greedy
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 * explanation:
 * 1. use a dummy node to store the head of the list
 * 2. use a pointer to iterate through the list
 * 3. return the result
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode cur = head;
        ListNode prevNode = dummyNode;

        while (hasKNodes(cur, k)) {
            prevNode = reverse(prevNode, cur, k);
            cur = prevNode.next;
        }

        return dummyNode.next;
    }

    private boolean hasKNodes(ListNode cur, int k) {
        while (cur != null && k > 0) {
            cur = cur.next;
            k--;
        }
        return k == 0;
    }

    private ListNode reverse(ListNode prevNode, ListNode cur, int k) {
        ListNode groupTail = cur;
        ListNode prev = cur.next;

        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        prevNode.next = prev;
        groupTail.next = cur;
        return groupTail;
    }
}