/**
 * Problem: Maximum Twin Sum of a Linked List
 * Platform: LeetCode
 *
 * Approach (Depth First Search):
 * 1. Use a depth first search to find the maximum twin sum of the linked list.
 * 2. Use a helper function to find the maximum twin sum of the linked list.
 * 3. Return the maximum twin sum of the linked list.
 */
/**
 * Time Complexity: O(n)

/**
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a depth first search to find the maximum twin sum of the linked list.
 * 2. We use a helper function to find the maximum twin sum of the linked list.
 * 3. We return the maximum twin sum of the linked list.
 */
class Solution {
    private ListNode left;
    private int maxSum = 0;

    public int pairSum(ListNode head) {
        left = head;
        dfs(head);
        return maxSum;
    }

    private void dfs(ListNode right) {
        if (right == null) {
            return;
        }

        dfs(right.next);

        maxSum = Math.max(maxSum, left.val + right.val);
        left = left.next;
    }
}
