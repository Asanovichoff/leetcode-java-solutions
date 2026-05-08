/**
 * Problem: Sum Root to Leaf Numbers
 * Platform: LeetCode
 *
 * Approach (Depth First Search):
 * 1. Use a depth first search to calculate the sum of the root to leaf numbers.
 * 2. Use a helper function to calculate the sum of the root to leaf numbers.
 * 3. Return the sum of the root to leaf numbers.
 */
/**
 * Time Complexity: O(n)

/**
 * Space Complexity: O(h)
 * 
 * Explanation:
 * 1. We use a depth first search to calculate the sum of the root to leaf numbers.
 * 2. We use a helper function to calculate the sum of the root to leaf numbers.
 * 3. We return the sum of the root to leaf numbers.
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int current) {
        if (node == null) return 0;
        current = current * 10 + node.val;
        if (node.left == null && node.right == null) {
            return current;
        }
        return dfs(node.left, current) + dfs(node.right, current);
    }
}
