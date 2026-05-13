/**
 * Problem: Binary Tree Maximum Path Sum
 * Platform: LeetCode
 *
 * Approach (Depth First Search):
 * 1. Use a depth first search to find the maximum path sum.
 * 2. Use a helper function to find the maximum path sum.
 * 3. Return the maximum path sum.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * 
 * Explanation:
 * 1. We use a depth first search to find the maximum path sum.
 * 2. We use a helper function to find the maximum path sum.
 * 3. We return the maximum path sum.
 */

class Solution {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftSum = Math.max(dfs(node.left), 0);
        int rightSum = Math.max(dfs(node.right), 0);
        int currentPath = node.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, currentPath);

        return node.val + Math.max(leftSum, rightSum);
    }
}
